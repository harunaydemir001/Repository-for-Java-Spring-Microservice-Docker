package com.innova.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innova.login.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}