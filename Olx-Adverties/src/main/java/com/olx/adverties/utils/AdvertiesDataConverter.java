package com.olx.adverties.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.olx.adverties.dto.Advertise;
import com.olx.adverties.entity.AdvertiseEntity;

public class AdvertiesDataConverter {
	
	@Autowired
	ModelMapper modelMapper;
		
	public Advertise convertCategoryEntityIntoCategoryDto(AdvertiseEntity advertiseEntity) {
//	 Category category = new Category();
//		category.setId(categoryEntity.getId());
//		category.setCategory(categoryEntity.getCategory());
		
		Advertise advertise = this.modelMapper.map(advertiseEntity, Advertise.class);
		return advertise;
 }

}
