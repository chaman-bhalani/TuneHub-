package com.example.sb.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.tunehub.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email);
}
