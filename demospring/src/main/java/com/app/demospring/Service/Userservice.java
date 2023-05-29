package com.app.demospring.Service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.demospring.dto.Userdto;
import com.app.demospring.repository.Userrepository;

@org.springframework.stereotype.Service
public class Userservice {
	
	@Autowired
	private  Userrepository repository;
	private Userdto userdto;
	
	public Userdto save(Userdto dto) throws ClassNotFoundException, SQLException{
		System.out.println("2");
		return repository.user(dto); 
		}
	public List<Userdto> getdetails() throws ClassNotFoundException, SQLException{
		System.out.println("2");
		return repository.getAllDetails(); 
		}
	
	public Userdto put(@RequestBody Userdto dto) throws ClassNotFoundException, SQLException{
		 return repository.update(dto); 
	}
	public String Delete() throws ClassNotFoundException, SQLException {
	repository.delete();
	return "deleted" ;
	}

	public List<Userdto>getselecteddetails() throws ClassNotFoundException, SQLException{
		System.out.println("2");
		return repository.	getselecteddetails(); 
		}
	
	}
	
//	public String Delete(Integer id) throws ClassNotFoundException, SQLException {
//		repository.delete(id);
//		return "deleted" ;
//	}
		
