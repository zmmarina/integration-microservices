package com.zm.microservice.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zm.microservice.users.VO.Department;
import com.zm.microservice.users.VO.ResponseTemplateVO;
import com.zm.microservice.users.entity.User;
import com.zm.microservice.users.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser method of UserService");
		return userRepository.save(user);
	}

//	public User findUserById(Long userId) {
//		log.info("Inside findUserById method of UserService");
//		return userRepository.findUserById(userId);
//	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment method of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findUserById(userId);		
		Department department = restTemplate.getForObject("http://MICROSERVICES/departments/" + user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);		
		return vo;
	}

}
