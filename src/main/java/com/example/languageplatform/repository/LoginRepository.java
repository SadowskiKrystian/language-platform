package com.example.languageplatform.repository;

import com.example.languageplatform.dto.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Override
    <S extends Login> S save(S entity);
}
