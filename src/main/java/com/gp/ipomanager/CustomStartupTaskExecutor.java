package com.gp.ipomanager;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gp.ipomanager.entities.Address;
import com.gp.ipomanager.entities.Role;
import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.repository.AddressRepository;
import com.gp.ipomanager.repository.RoleRepository;
import com.gp.ipomanager.repository.UserRepository;

@Component
public class CustomStartupTaskExecutor {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@PostConstruct
	public void createDefaultAdmin() {
		System.out.println("Inside create admin");
		
		User u=userRepository.findByUsername("admin");
		System.out.println("Looked for admin");
		if(u==null) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			
			u=new User();
			u.setUsername("admin");
			u.setPassword(encoder.encode("123456"));
			
			Role r=new Role();
			r.setName("admin");
			r=roleRepository.save(r);
			Set<Role> rs=new HashSet<>();
			rs.add(r);
			u.setRoles(rs);
			u.setActive(true);
			
			userRepository.save(u);
			
			Role r2=new Role();
			r2.setName("candidate");
			r2=roleRepository.save(r2);
			
			
			System.out.println(" created default admin user");
			
			

			
			
			User candidate1user=new User();
			candidate1user.setUsername("Dipendra");
			candidate1user.setPassword(encoder.encode("123456"));
			candidate1user.setActive(true);
			candidate1user.setProfileCreated(true);
			
			Set<Role> rset=new HashSet<>();
			rset.add(r2);
			candidate1user.setRoles(rset);
			
			userRepository.save(candidate1user);
			
			Address a=new Address();
			a.setCountry("Nepal");
			a.setMunicipalty("Chitwan");
			a.setState("Bagmati");
			addressRepository.save(a);
			
			
			
		}
	}
}
