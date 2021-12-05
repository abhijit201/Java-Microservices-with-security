package com.olx.adverties.service;

import com.olx.adverties.dto.Category;
import com.olx.adverties.dto.Status;

public interface MasterDataDelegate {

	public Category getCategoryById(int categoryId);
	public Status getStatusById(int statusId);
}
