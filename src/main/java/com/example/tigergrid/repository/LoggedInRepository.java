package com.example.tigergrid.repository;

import com.example.tigergrid.model.LoggedIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedInRepository extends JpaRepository<LoggedIn, Integer> {
}
