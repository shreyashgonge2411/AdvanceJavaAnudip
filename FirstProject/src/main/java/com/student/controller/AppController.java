package com.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/health_check")
	public String health() {
		return "Site Health is fine";
	}
}
