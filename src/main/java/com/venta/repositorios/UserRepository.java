package com.venta.repositorios;

import com.venta.proy.User;

public interface UserRepository {
	
	public User findOne(Integer id);
	public Iterable<User> findAll();
	public void save(User user);
	public void update(User user);
	public void delete(User user);
}

