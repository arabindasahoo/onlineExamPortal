package com.exam.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtil jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestHeader = request.getHeader("Authorization");

		

		String username = null;
		String jwtToken = null;

		if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
			jwtToken = requestHeader.substring(7);

			try {
				username = this.jwtUtils.extractUsername(jwtToken);

			} catch (ExpiredJwtException e) {

				e.printStackTrace();
				System.out.println("JWT TOKEN HAS EXPIRED");
			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("error");
			}

		} else {
			System.out.println("Invalid token, Not start with Bearer");
		}

		// validate User

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);

			if (this.jwtUtils.validateToken(jwtToken, userDetails)) {
				// Token is valid

				UsernamePasswordAuthenticationToken UsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				UsernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthenticationToken);
			} else {
				System.out.println("Token is not valid");
			}
		}

		filterChain.doFilter(request, response);

	}

}
