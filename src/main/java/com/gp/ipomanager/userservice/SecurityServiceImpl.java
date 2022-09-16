package com.gp.ipomanager.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.gp.ipomanager.entities.User;
import com.gp.ipomanager.repository.UserRepository;

@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }
    
    @Override
    public User getLoggedInUser() {
    	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
    	if(auth==null) {
    		return null;
    	}
    	Object principal=auth.getPrincipal();
    	System.out.println(principal.getClass() +"--------the class of principle ");
    	
    	
    	
    	if(principal instanceof org.springframework.security.core.userdetails.User) {
    		User u=userRepository.findByUsername(((org.springframework.security.core.userdetails.User) principal).getUsername());
    		
    		return u;
    	}
    	
        Object userDetails = auth.getDetails();
        if (userDetails instanceof UserDetails) {
        	
        	String un=((UserDetails)userDetails).getUsername();
        	User u=userRepository.findByUsername(un);
            return u;
        }

        return null;
    }
    
}
