package com.bts.poc.facture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bts.poc.facture.model.ERole;
import com.bts.poc.facture.model.Role;
import com.bts.poc.facture.repository.RoleRepository;

@SpringBootApplication
public class PocFactureApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PocFactureApplication.class, args);
	}
	
	@Autowired
	RoleRepository roleRepository;

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
		
	}
	
	

}
