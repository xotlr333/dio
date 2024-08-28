package com.ktds.dio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.dio.dto.TestInDto;
import com.ktds.dio.dto.TestOutDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

	@GetMapping("/get")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("get method");
	}

	@PostMapping("/post")
	public ResponseEntity<String> post() {
		return ResponseEntity.ok("post method");
	}

	@PostMapping("/post")
	public ResponseEntity<TestOutDto> post(@RequestBody TestInDto testInDto) {
		TestOutDto testOutDto = new TestOutDto();
		testOutDto.setCode(1);
		testOutDto.setMsg(testInDto.getName() + "||" + testInDto.getId());

		return ResponseEntity.ok(testOutDto);
	}
}
