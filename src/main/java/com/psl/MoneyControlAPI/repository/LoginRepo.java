package com.psl.MoneyControlAPI.repository;

import com.psl.MoneyControlAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<User, Long> {

    Optional<User> findOneByEmailAndPassword(String email, String Password);
    User findByEmail(String Email);

}
