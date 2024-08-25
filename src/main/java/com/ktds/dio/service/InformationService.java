package com.ktds.dio.service;

import org.springframework.stereotype.Service;

import com.ktds.dio.domain.Information;
import com.ktds.dio.repository.InformationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InformationService {

	private final InformationRepository informationRepository;

	public Information findByMemberId(Long memberId) {
		return informationRepository.findByMemberId(memberId);
	}
}
