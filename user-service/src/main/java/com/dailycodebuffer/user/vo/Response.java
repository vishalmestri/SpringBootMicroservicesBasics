package com.dailycodebuffer.user.vo;

import com.dailycodebuffer.user.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	
	Users user;
	Department department;
	
}
