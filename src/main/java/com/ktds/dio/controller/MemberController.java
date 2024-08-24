package com.ktds.dio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.dio.domain.Member;
import com.ktds.dio.service.MemberService;
import com.ktds.dio.service.ShaUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final ShaUtil shaUtil;

	@PostMapping("login")
	public ResponseEntity<Boolean> login(@RequestBody Member member, HttpServletRequest request) {

		Member findMember = memberService.findByLoginId(member.getLoginId());

		System.out.println(findMember.getName());
		if(findMember == null) {
			return ResponseEntity.ok(false);
		}

		System.out.println("들어온값 : " + member.getPassword());
		System.out.println("들어온값 암호화 : " + shaUtil.sha256Encode(member.getPassword()));
		System.out.println("DB 값 : " + findMember.getPassword());
		if(!findMember.getPassword().equals(shaUtil.sha256Encode(member.getPassword()))) {
			return ResponseEntity.ok(false);
		}

		HttpSession session = request.getSession();
		session.setAttribute("memberInfo", findMember);

		return ResponseEntity.ok(true);

	}

	@GetMapping("/logout")
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}

	}
}
