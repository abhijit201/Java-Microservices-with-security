package com.olx.masterdata.service;

import java.util.List;

import com.olx.masterdata.dto.Category;
import com.olx.masterdata.dto.Status;

public interface MasterDataService {

    List<Status> getStatus();

    Status getStatusById(int id);

    List<Category> getCategories();

    Category getCategoryById(int id);
}
