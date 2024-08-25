package com.ktds.dio.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.dio.domain.Information;
import com.ktds.dio.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InformationRepository {

	private final SqlSessionTemplate sql;

	public Information findByMemberId(Long memberId) {
		return sql.selectOne("Information.findByMemberId", memberId);
	}
}
