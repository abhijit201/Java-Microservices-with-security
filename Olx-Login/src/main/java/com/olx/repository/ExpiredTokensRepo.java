package com.olx.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.ExpiredToken;


public interface ExpiredTokensRepo extends JpaRepository<ExpiredToken, Integer> {

	ExpiredToken findByBlacklistedJwt(String authToken);
}
