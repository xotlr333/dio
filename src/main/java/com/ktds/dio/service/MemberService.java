package com.ktds.dio.service;

import org.springframework.stereotype.Service;

import com.ktds.dio.domain.Member;
import com.ktds.dio.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;


	public Member findByLoginId(String loginId) {
		return memberRepository.findByLoginId(loginId);
	}


}
