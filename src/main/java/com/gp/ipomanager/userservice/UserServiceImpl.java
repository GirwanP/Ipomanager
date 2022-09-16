package com.gp.ipomanager.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gp.ipomanager.entities.Role;
import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.repository.RoleRepository;
import com.gp.ipomanager.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    
    @Override
    public void saveCandidateUser(User user) {
    	 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         Role r=roleRepository.findByName("candidate");
        Set<Role> rset=new HashSet<>();
        rset.add(r);
        
         user.setRoles(rset);
         userRepository.save(user);
    }
    
    @Override
    public void saveAdminUser(User user) {
    	 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         Role r=roleRepository.findByName("admin");
        Set<Role> rset=new HashSet<>();
        rset.add(r);
        
         user.setRoles(rset);
         userRepository.save(user);
    }
    
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    
    @Override
    public boolean disableUser(String username) {
        
    	try {
    	User u=userRepository.findByUsername(username);
        u.setActive(false);
        userRepository.save(u);
    	}catch(Exception e) {
    		return false;
    	}
    	return true;
    }
    
    @Override
    public boolean activateUser(String username) {
        
    	try {
    	User u=userRepository.findByUsername(username);
        u.setActive(true);
        userRepository.save(u);
    	}catch(Exception e) {
    		return false;
    	}
    	return true;
    }
    
    @Override
    public boolean isCurrentUserAdmin(User u) {
        
    	try {
    	Role r=roleRepository.findByName("admin");
    	
    		if(u.getRoles().contains(r)) {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return false;
    	}
    	return false;
    
    }
    @Override
    public boolean isCurrentUserCustomer(User u) {
        
    	try {
    	Role r=roleRepository.findByName("admin");
    	
    		if(u.getRoles().contains(r)) {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return false;
    	}
    	return false;
    }
}
