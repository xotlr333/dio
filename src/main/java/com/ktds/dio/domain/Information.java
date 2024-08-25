package com.ktds.dio.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Information {

	private Long id;
	private LocalDate createdAt;
	private String mobileProduct;
	private String payment;
	private String phoneNumber;
	private String prodectChangeDate;
	private String mobileData;
	private String voice;
	private String sms;
	private String contractDiscountAmount;
	private String discountType;
	private String contractDate;
	private String discountAmount;
	private String discountRefund;
	private String totalDiscountAmount;
	private Long memberId;
}
