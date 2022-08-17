package com.springboot.app.monitoring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.Role;


@Repository
public interface RoleRepository extends JpaRepository <Role, Long>{
	Optional<Role> findByRoleName(String roleName);
}