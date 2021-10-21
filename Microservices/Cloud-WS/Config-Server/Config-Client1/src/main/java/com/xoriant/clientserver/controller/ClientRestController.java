package com.xoriant.clientserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/toys")
@RefreshScope
@CrossOrigin
public class ClientRestController {
	
	@Value("${message}")
	private String msg;

	@GetMapping
	public String getMessage() {
		return "Message is "+msg;
	}
}