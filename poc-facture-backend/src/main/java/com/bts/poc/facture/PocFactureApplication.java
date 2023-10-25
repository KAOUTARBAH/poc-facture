package com.bts.poc.facture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

import com.bts.poc.facture.controllers.AuthController;
import com.bts.poc.facture.model.ERole;
import com.bts.poc.facture.model.Role;
import com.bts.poc.facture.model.User;
import com.bts.poc.facture.payload.request.SignupRequest;
import com.bts.poc.facture.payload.response.MessageResponse;
import com.bts.poc.facture.repository.RoleRepository;
import com.bts.poc.facture.repository.UserRepository;

import jakarta.validation.Valid;

@SpringBootApplication
public class PocFactureApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PocFactureApplication.class, args);
	}
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthController authController;
	
	//private PasswordEncoder passwordEncoder;

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//List<Role> role = new ArrayList<Role>();
		
		
	

		
		Role role1 = new Role();
		role1.setId("1");
		role1.setName(ERole.ROLE_USER);
		
		Role role2 = new Role();
		role2.setId("2");
		role2.setName(ERole.ROLE_ADMIN);
		
		Role role3 = new Role();
		role3.setId("3");
		role3.setName(ERole.ROLE_MODERATOR);
		
		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);
		
		System.out.println(role1);
		System.out.println(role2);
		System.out.println(role3);
		
		User user1 = new User("admin", "admin@gmail.com", passwordEncoder().encode("1234567"));
		user1.setId("1");
		//List<Role> roles = new ArrayList<Role>();
		HashSet<Role>roles = new HashSet<Role>();
		roles.add(role1);
		roles.add(role2);
		user1.setRoles(roles);
		
		
		//password(passwordEncoder.encode("1234"))
		
		User user2 = new User();
		user2.setId("2");
		user2.setUsername("kaoutar");
		user2.setEmail("kaoutar@gmail.com");
		user2.setPassword(passwordEncoder().encode("1234567"));
		
		
		HashSet<Role>roles2 = new HashSet<Role>();
		roles2.add(role1);
		roles2.add(role2);
		user2.setRoles(roles2);
		
		System.out.println(user1);
		System.out.println(user2);
		userRepository.save(user1);
		userRepository.save(user2);
		
			
		 
		
	}
	
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
