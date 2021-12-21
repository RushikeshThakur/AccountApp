package com.amdocs.accountsappliction.helperobject;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {

	private Object data;
	private boolean success;
	private Object message;
	private HttpStatus status;
}
