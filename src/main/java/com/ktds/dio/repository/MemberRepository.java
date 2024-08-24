package com.ktds.dio.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.dio.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final SqlSessionTemplate sql;

	public Member findByLoginId(String loginId) {
		return sql.selectOne("Member.findByLoginId", loginId);
	}

}
