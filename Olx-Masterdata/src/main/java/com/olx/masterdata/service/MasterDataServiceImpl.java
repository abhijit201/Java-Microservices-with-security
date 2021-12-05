package com.olx.masterdata.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.masterdata.dto.Category;
import com.olx.masterdata.dto.Status;
import com.olx.masterdata.entity.CategoryEntity;
import com.olx.masterdata.entity.StatusEntity;
import com.olx.masterdata.exception.InvalidCategoryIdException;
import com.olx.masterdata.exception.InvalidStatusIdException;
import com.olx.masterdata.repository.CategoriesRepository;
import com.olx.masterdata.repository.StatusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MasterDataServiceImpl implements MasterDataService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getStatus() {
    	List<StatusEntity> statusEntities = statusRepository.findAll();
		return getStatusDtoList(statusEntities);	
	}

    @Override
    public Status getStatusById(int id) {
    	Optional<StatusEntity> entity = statusRepository.findById(id);
		if(entity.isPresent())
		{
			StatusEntity statusEntity = entity.get();
			Status status = new Status(id, statusEntity.getName());
			return status;
		} else {
            throw new InvalidStatusIdException(id);
        }
    }

    private List<Status> getStatusDtoList(List<StatusEntity> statusEntities) {
		List<Status> categories = new ArrayList<Status>();
		for(StatusEntity statusEntity: statusEntities) {
			Status status = this.modelMapper.map(statusEntity, Status.class);
			categories.add(status);
		}
		return categories;
	}
    
    @Override
    public List<Category> getCategories() {
    	List<CategoryEntity> categoryEntityList = categoriesRepository.findAll();
		return getCategoryDtoList(categoryEntityList);    }

    @Override
    public Category getCategoryById(int id) {
    	Optional<CategoryEntity> entity = categoriesRepository.findById(id);
		if(entity.isPresent()){
			CategoryEntity categoryEntity = entity.get();
			Category category = new Category(id, categoryEntity.getName());
			return category;
		} else {
            throw new InvalidCategoryIdException(id);
        }
    }
    
    private List<Category> getCategoryDtoList(List<CategoryEntity> categoryEntities) {
		List<Category> categories = new ArrayList<Category>();
		for(CategoryEntity categoryEntity: categoryEntities) {
			Category category = this.modelMapper.map(categoryEntity, Category.class);
			categories.add(category);
		}
		return categories;
	}

}
