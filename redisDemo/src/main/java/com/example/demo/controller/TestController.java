package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.DemoQuery;


@RestController
public class TestController {

	@Autowired
	DemoQuery demoQuery;
	@RequestMapping("/test")
	public String test() {
		demoQuery.test();
		return "OK";
	}
	
}
