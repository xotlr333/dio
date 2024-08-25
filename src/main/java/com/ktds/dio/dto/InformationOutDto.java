package com.ktds.dio.dto;

import com.ktds.dio.domain.Information;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformationOutDto {

	private int code;
	private Information information;
}
