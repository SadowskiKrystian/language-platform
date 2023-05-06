package com.example.languageplatform.repository;

import com.example.languageplatform.dto.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Override
    <S extends Profile> S save(S entity);
}
