package com.olx.adverties.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.olx.adverties.entity.AdvertiseEntity;

public interface AdvertiesRepository extends JpaRepository<AdvertiseEntity, Integer> {

	
//	 @Query("SELECT a FROM Advertise a WHERE a.title LIKE %:searchText% or a.category LIKE %:searchText% or a.description LIKE %:searchText% ")
//	 List <AdvertiseEntity> findByText(@Param("searchText") String searchText);
}
