package com.app.demospring.controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demospring.Service.Userservice;
import com.app.demospring.dto.Userdto;



@RestController
@RequestMapping("/controller")
 
public class Usercontroller {
	@Autowired
	private Userservice service;
	
	@GetMapping(value = "/get")
	public List<Userdto> get() throws ClassNotFoundException, SQLException {
			return service.getdetails();
		
		
	}
	@PostMapping(value ="/post")
	public Userdto post(@RequestBody Userdto dto ) throws ClassNotFoundException, SQLException {
		System.out.println("1");
		return service.save(dto);
	}
	@PutMapping(value ="/put")
	public Userdto put(@RequestBody Userdto dto ) throws ClassNotFoundException, SQLException {
	 return service.put(dto);
	}
	@DeleteMapping(value ="/Delete")
	public String Delete(  ) throws ClassNotFoundException, SQLException {
		System.out.println("1");
	 return service.Delete();
	}
	
	
	@GetMapping(value = "/getselecteddetails")
	public List<Userdto> getselecteddetails() throws ClassNotFoundException, SQLException {
			return service.getselecteddetails();
	}
	
//	@DeleteMapping(value ="/Delete/{id}")
//	public String Delete(@PathVariable Integer id ) throws ClassNotFoundException, SQLException {
//		System.out.println("1");
//	 return service.Delete(id);
//	}
}
