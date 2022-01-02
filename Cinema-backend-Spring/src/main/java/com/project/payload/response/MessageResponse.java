package com.project.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MessageResponse {


	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	private String message;

}
