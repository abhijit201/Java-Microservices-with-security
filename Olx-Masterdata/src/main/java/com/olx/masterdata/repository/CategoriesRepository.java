package com.olx.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.masterdata.entity.CategoryEntity;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {

}
