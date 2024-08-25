package com.ktds.dio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.dio.domain.Information;
import com.ktds.dio.domain.Member;
import com.ktds.dio.dto.InformationOutDto;
import com.ktds.dio.service.InformationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("info")
@RequiredArgsConstructor
public class InformationController {

	private final InformationService informationService;

	@PostMapping("myMobile")
	public ResponseEntity<InformationOutDto> findByMemberId(@RequestBody Member member, HttpServletRequest request) {

		InformationOutDto response = new InformationOutDto();

		HttpSession session = request.getSession();
		Member sessionMember = (Member)session.getAttribute("memberInfo");

		if(sessionMember == null) {
			response.setCode(0);
			return ResponseEntity.ok(response);
		}

		if(!member.getLoginId().equals(sessionMember.getLoginId())) {
			response.setCode(0);
			return ResponseEntity.ok(response);
		}

		Information information = informationService.findByMemberId(sessionMember.getId());

		response.setInformation(information);
		response.setCode(1);

		return ResponseEntity.ok(response);

	}
}
