package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

	Role findByRoleName(String string);

}
