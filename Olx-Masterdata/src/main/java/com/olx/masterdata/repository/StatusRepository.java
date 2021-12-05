package com.olx.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.masterdata.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

}
