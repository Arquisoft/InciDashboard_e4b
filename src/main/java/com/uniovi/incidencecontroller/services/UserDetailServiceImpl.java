package com.uniovi.incidencecontroller.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.repositories.OperarioRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private OperarioRepository operarioRepository;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException{
		Operario user = operarioRepository.findByDni(dni);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_OPERARIO"));

		return new org.springframework.security.core.userdetails.User(
				user.getDni(), user.getPassword(), grantedAuthorities);
	}

}
