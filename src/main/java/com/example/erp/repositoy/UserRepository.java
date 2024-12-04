package com.example.erp.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.enttity.User;

public interface UserRepository extends JpaRepository<User, Integer>{ 

}
