package com.dailycodebuffer.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private Long id;
	private String name;
	private String address;
	private String code;
	
}
