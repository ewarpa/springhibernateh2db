package com.ridvanogras.steelorbis.demo.steelorbis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridvanogras.steelorbis.demo.steelorbis.model.User;
import com.ridvanogras.steelorbis.demo.steelorbis.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/checkUser")
	public ResponseEntity<Boolean> userDetails(@RequestParam(name = "username") String userName,
			@RequestParam(name = "password") String password) {
		User userDetails = new User();
		userDetails.setPassword(password);
		userDetails.setName(userName);

		return new ResponseEntity<Boolean>(userService.checkUserDetails(userDetails), HttpStatus.OK);
	}
}
