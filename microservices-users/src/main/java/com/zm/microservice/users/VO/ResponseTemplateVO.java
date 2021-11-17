package com.zm.microservice.users.VO;

import com.zm.microservice.users.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	
	private User user;
	private Department department;

}
