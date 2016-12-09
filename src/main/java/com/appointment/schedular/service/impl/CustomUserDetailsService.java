/**
 * 
 */
package com.appointment.schedular.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dhyanandra
 *
 */
@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
 
   
    
	public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
      
    	String employee = "bill";
        if(!employee.equals(email)){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(employee
            		, "abc123",true, true, true, true, getGrantedAuthorities(employee));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(String employee){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
       
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        System.out.print("authorities :"+authorities);
        return authorities;
    }
     
}