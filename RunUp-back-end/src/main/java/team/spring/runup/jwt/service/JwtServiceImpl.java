package team.spring.runup.jwt.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import team.spring.runup.user.vo.User;

@Component
@Service
public class JwtServiceImpl {

	private String secretKey = "myKey";
	private long exp = 1000L * 180 * 60; // 토큰사용시간 1시간
	
	// 토큰생성
	public String createToken(User user) {
		return Jwts.builder()
				   .setHeaderParam("typ", "JWT") // 토큰 타입
				   .setSubject("userToken") // 토큰 제목
				   .setExpiration(new Date(System.currentTimeMillis() + exp)) // 토큰 유효시간
				   .claim("user", user) // 토큰에 담을 데이터
				   .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // secretKey를 사용하여 해싱 암호화 알고리즘 처리
				   .compact(); // 직렬화, 문자열로 변경
	}
	
	// 토큰 정보 가져기
	public Map<String, Object> getInfo(String token) throws Exception{
		
		Jws<Claims> claims = null;
		claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
		
		return claims.getBody();
	}
	
	public void checkVaild(String toekn) {
		Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(toekn);
	}
	
}
