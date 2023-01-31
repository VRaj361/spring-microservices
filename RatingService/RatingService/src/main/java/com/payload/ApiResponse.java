package com.payload;

import org.springframework.http.HttpStatus;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
	
	private String msg;
	private HttpStatus status;
	private boolean success;

	
		
}
