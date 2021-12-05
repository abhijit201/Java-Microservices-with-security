package com.olx.adverties.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.olx.adverties.dto.Advertise;
import com.olx.adverties.entity.AdvertiseEntity;

public interface AdvertiesService {
	
	public List<Advertise> getAllAdvertises();
	
	public ResponseEntity<?> postNewAdvertise(Advertise advertise, String authtoken);
	
	public ResponseEntity<?> updateAdvertise(int advertiesID, Advertise advertise, String authtoken);
	
	public Boolean DeleteByPostID(int postId); 
	
	
	
	
	
	
	
	
	
	

	
	public List<Advertise> getAllAdvertiseByLoggedInUser(List<AdvertiseEntity> advertiseEntities); 

	public Advertise getSpecificAdvertiseByLoggedInUser(int postId); 


	public List<Advertise> getAllAdvertiseByFilter(); 

	public List<Advertise> getAllAdvertiseByFilterSearchText(); 
	
	public Advertise getAdvertiseDetailsUsingPostID(int postId);
	
//	ResponseEntity<?> filterandsearch(int page, int size, String title, Integer category, Integer status, Double price,String dateCondition, String onDate,String fromDate, String toDate,String sortBy, String order);

}
