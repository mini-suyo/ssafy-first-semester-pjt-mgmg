package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private String key = "Min_Seung_Yong_Lee_Se_Jung_SSAFY_1st_Project";

	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

	// 토큰 생성
	public String createToken(int userNo, String userName, boolean mateFlag) {

		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // Refresh 배우기 전 까지는 1시간

		return Jwts.builder().header().add("typ", "JWT").and()
				.claim("userNo", userNo).claim("userName", userName).claim("mateFlag", mateFlag)
				.expiration(exp)
				.signWith(secretKey).compact();
	}

	// 유효성 검증
	public Jws<Claims> validate(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
	
	
	// 토큰 리프레시
	//
	// 차후에 만들 것
	
}
