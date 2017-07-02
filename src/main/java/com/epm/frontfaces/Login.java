package com.epm.frontfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epm.dao.UsersDAO;
import com.epm.dao.impl.UsersDAOImpl;
import com.epm.dto.ResponseMessage;
import com.epm.dto.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/login")
public class Login {
	UsersDAO udao = new UsersDAOImpl(); 
	/*= new UsersDAOImpl();*/
	//UsersDAO udao = new UserDAOImpl();
	
	Users userDetails;
	
	@POST
	@Path("/page")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String userLoginPage(Users user) throws JsonProcessingException{
		System.out.println("Hello at least in class");
		
		// userDetails from class for all the methods.
		userDetails.setUser_id(user.getUser_id());
		
		System.out.println(user.getUser_id());
		System.out.println(user.getPassword());		
		ResponseMessage response = new ResponseMessage();
		//udao.login(int user_id, String password)
		if(udao.login(user.getUser_id(), user.getPassword())){
			System.out.println("We got from SQL");
			response.setMessage("OK");
			response.setResCode(200);
		}else{
			System.out.println("No user find");
			response.setMessage("No Content");
			response.setResCode(204);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonToSend = mapper.writeValueAsString(response);
		
		return jsonToSend;
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public String sendUserDetails() throws JsonProcessingException{		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(udao.viewProfile(userDetails.getUser_id()));
		//												top is returing user
		return userJson;
	}

}
