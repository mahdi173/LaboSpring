package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.User;
import com.example.web.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	 UserService userService;
	
	@PostMapping("/users/signup")
	public ResponseEntity register(@RequestBody User newUser)  {

		if(userService.addUser(newUser) != null) {
		 return new ResponseEntity(HttpStatus.OK);
			
		}else {
			return new ResponseEntity( HttpStatus.BAD_REQUEST);
		}
  }
	@PostMapping("/users/login")
	public ResponseEntity<User>  login(@RequestBody User user )  {
        User u= userService.auth(user);
		if(u != null) {

		 return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

  }
	
	@GetMapping("/users/index")
	public List<User> getUser()  {
      
		return userService.getUsers();
       
 }
	@GetMapping("/verify/{token}")
	public ResponseEntity<String>   verifyEmail(@PathVariable("token") String token)  {
     
		if(userService.emailVerification(token) != null) {
			 return new ResponseEntity<>(" Sucess ", HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(" Error ", HttpStatus.BAD_REQUEST);
			}
	}

}
