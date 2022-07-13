package com.maderacnc.MaderaCNC.jwt.config;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	public static String secret = "Git-Status-oneDirection-bts";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader =  httpServletRequest.getHeader("authorization");
		if(("POST".equals(httpServletRequest.getMethod())) ||
		   ("PUT".equals(httpServletRequest.getMethod())) ||
		   ("DELET".equals(httpServletRequest.getMethod()))) {
				if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
					throw new ServletException("1. Invalid Token");
				}
				String token = authHeader.substring(7);
				try {
				Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException  e) {
				throw new ServletException("2. Invalid Token.");
			  }
		}
			chain.doFilter(request,response);
	}
}