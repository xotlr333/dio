package com.ktds.dio.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

	private Long id;
	private String name;
	private String loginId;
	private String password;
	private LocalDate createdAt;
}
