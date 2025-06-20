package com.web.HealCraft.userprofile.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.HealCraft.userprofile.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
