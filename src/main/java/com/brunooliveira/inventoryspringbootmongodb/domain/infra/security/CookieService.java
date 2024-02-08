package com.brunooliveira.inventoryspringbootmongodb.domain.infra.security;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {

	public static void setCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(7200);
		cookie.setAttribute("HttpOnly", "true");
		cookie.setAttribute("SameSite", "None");
		cookie.setPath("/");
		cookie.setSecure(true);
		response.addCookie(cookie);
	}

	public static Optional<String> getCookieValue(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return Optional.empty();
		return Arrays.stream(cookies)
				.filter(e -> key.equals(e.getName()))
				.findAny()
				.map(e -> e.getValue());
	}

}
