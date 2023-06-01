package team.spring.runup.report.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


import team.spring.runup.report.service.ReportService;
import team.spring.runup.report.vo.Report;

@RestController
@RequestMapping(value="report",produces="application/json; charset=UTF-8")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ReportController {
	
	Logger log = LogManager.getLogger("case3");
		
	@Autowired
	private ReportService reportservice;
	
	@GetMapping(value="all")
	public ResponseEntity<List<Report>> allReport() throws JsonProcessingException {
		
		List<Report> reportList = reportservice.getReportList();
		
		return ResponseEntity.ok(reportList);
	}
	
	@GetMapping
	public ResponseEntity<Report> searchReport(@RequestParam(value="reportNum", required=false) int reportNum) throws JsonProcessingException {
		
		Report reportOne = reportservice.getReport(reportNum);
		
		return ResponseEntity.ok(reportOne);
	}
	
	@GetMapping(value="img")
	public ResponseEntity<String> imgReport(@RequestParam(value="reportNum", required=false) int reportNum) throws JsonProcessingException {
		
		String imgUrl = reportservice.getReportImage(reportNum);
		
		return ResponseEntity.ok(imgUrl);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createReport(
			@RequestPart Report report,
			@RequestPart(required = false) MultipartFile img) throws Exception {
		
		File credentialsPath = new File("C:/Users/user/Desktop/finalproject/data-gearbox-383608-78089e7acd65.json");
		
		Storage storage = StorageOptions.newBuilder()
		                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(credentialsPath)))
		                .build()
		                .getService();
		
        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of("runup", "report/" + img.getOriginalFilename()))
                .setContentType("image/jpeg")
                .build();
        
        Blob blob = storage.create(blobInfo, img.getBytes()); 
        
//      String test = blob.getMediaLink();

        String fileName = blob.getName();
        String fileUrl = "https://storage.googleapis.com/runup/" + fileName;
		report.setReportFile(fileUrl);
		int result = reportservice.createReport(report);
				
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteReport(@RequestBody Report report) throws JsonProcessingException {
		
		int result = reportservice.deleteReport(report);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateReport(@RequestBody Report report) throws Exception {
		
		int result = reportservice.updateReport(report);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(value="file")
	public ResponseEntity<Integer> updateReportFile(@RequestPart(value="img2",required=false) MultipartFile img2,
			@RequestParam Integer reportNum) throws Exception {
		log.debug(reportNum);
		Report report = new Report();
		
		File credentialsPath = new File("C:/Users/user/Desktop/finalproject/data-gearbox-383608-78089e7acd65.json");
		
		Storage storage = StorageOptions.newBuilder()
		                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(credentialsPath)))
		                .build()
		                .getService();
		
		if (img2 != null) {
        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of("runup", "report/" + img2.getOriginalFilename()))
                .setContentType("image/jpeg")
                .build();
        
        Blob blob = storage.create(blobInfo, img2.getBytes()); 
        
//      String test = blob.getMediaLink();

        String fileName = blob.getName();
        String fileUrl = "https://storage.googleapis.com/runup/" + fileName;
		report.setReportFile(fileUrl);
		
		
		}
		
		report.setReportNum(reportNum);
		int result = reportservice.updateReportFile(report);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="storage")
	public ResponseEntity<Integer> saveReport(@RequestBody Report report) throws JsonProcessingException {
		
		int result = reportservice.saveReport(report);
		
		return ResponseEntity.ok(result);
	}
}

