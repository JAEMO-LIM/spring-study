package org.example.ch12_ex23.repository;

import org.example.ch12_ex23.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
