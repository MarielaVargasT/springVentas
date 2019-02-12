package com.venta.repositorios.jpa;

import org.springframework.stereotype.Repository;

import com.venta.proy.User;
import com.venta.repositorios.UserRepository;

@Repository
public class UserRepositoryJPA extends GenericRepositoryJPA<User,Integer> implements UserRepository {

	public UserRepositoryJPA() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
}


