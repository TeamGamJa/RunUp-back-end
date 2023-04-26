package team.spring.runup.report.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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
@CrossOrigin(origins="http://localhost:8081", allowedHeaders = "*")
public class ReportController {
	
	Logger log = LogManager.getLogger("case3");
		
	@Autowired
	private ReportService reportservice;
	
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
        
//        String test = blob.getMediaLink();
//        log.debug(test);
        String fileName = blob.getName();
        String fileUrl = "https://storage.googleapis.com/runup/" + fileName;
		report.setReportFile(fileUrl);
		int result = reportservice.createReport(report);
				
		return ResponseEntity.ok(result);
	}
	
	
}
