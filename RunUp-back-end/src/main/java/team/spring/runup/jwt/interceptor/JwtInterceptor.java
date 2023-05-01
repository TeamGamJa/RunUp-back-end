package team.spring.runup.jwt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import team.spring.runup.jwt.service.JwtServiceImpl;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		} else {
			String token = request.getHeader("jwt-auth-token");
			if (!(token.equals(null)) && token.length() > 0) {
				jwtService.checkVaild(token);
				return true;
			} else {
				throw new Exception("유효한 인증토큰이 존재하지 않습니당");
			}
		}
	}
}
