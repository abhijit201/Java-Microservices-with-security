package com.olx.adverties.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olx.adverties.dto.Advertise;
import com.olx.adverties.dto.Category;
import com.olx.adverties.dto.Status;
import com.olx.adverties.entity.AdvertiseEntity;
import com.olx.adverties.exception.InvalidAuthTokenException;
import com.olx.adverties.exception.InvalidIdException;
import com.olx.adverties.repository.AdvertiesRepository;

@Service(value = "JPA_SERVICE")
public class AdvertiesServiceImpl implements AdvertiesService {
	
	@Autowired
	MasterDataDelegate dataDelegate;
	
	@Autowired
	AdvertiesRepository advertiesRepository;
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	LoginDelegate loginDelegate;

	@Override
	public List<Advertise> getAllAdvertises(){
		List<AdvertiseEntity> advertiseEntityList = advertiesRepository.findAll();
		return getAllAdvertiseByLoggedInUser(advertiseEntityList);		
	}
	
	
	@Override
	public ResponseEntity<?> postNewAdvertise(Advertise advertise, String token) {		
//		String ststusText = dataDelegate.getStatusById(advertise.getStatusId());
//		advertise.setStatusId(ststusText);
//		return null;
//		if (!loginDelegate.isValidToken(token)) {
//			throw new InvalidAuthTokenException("" + token);
//		}
		
//		Category category = dataDelegate.getCategoryById(advertise.getCategoryId());
//		Status status = dataDelegate.getStatusById(advertise.getStatusId());
//		advertise.setCategory(category.getCategory());
//		status.setStatus(status.getStatus());
		
//		AdvertiseEntity advertiseEntity= this.modelMapper.map(advertise, AdvertiseEntity.class);
//		advertiseEntity.setCategory(category.getCategory());
//		advertiseEntity.setStatus(status.getStatus());
//		advertiseEntity= this.advertiesRepository.save(advertiseEntity);
//		Advertise advertisedto = this.modelMapper.map(advertiseEntity, Advertise.class);
//		return ResponseEntity.ok(advertisedto);
		
		AdvertiseEntity entity = new AdvertiseEntity( advertise.getTitle(), advertise.getCategoryId(), advertise.getStatusId(),advertise.getPrice(),
				advertise.getDescription() );
//		Category category = dataDelegate.getCategoryById(advertise.getCategoryId());
//		Status status = dataDelegate.getStatusById(advertise.getStatusId());
//		advertise.setCategory(category.getCategory());
//		status.setStatus(status.getStatus());
		entity = advertiesRepository.save(entity);
		Advertise ad = new Advertise(entity.getId(), entity.getTitle(),
				/* category.getCategory(), */"CATAGORY","STATUS", entity
				.getPrice(), entity.getDescription(),entity.getCreated_date(), entity.getModified_date());
		return ResponseEntity.ok(ad);
		
		
	}
	
	@Override
	public ResponseEntity<?> updateAdvertise(int advertiesID, Advertise advertise, String token) {
//		if (!loginDelegate.isValidToken(token)) {
//			throw new InvalidAuthTokenException("" + token);
//		}
		
		Optional<AdvertiseEntity> opadvertiseEntity = advertiesRepository.findById(advertiesID);
//		Category category = dataDelegate.getCategoryById(advertise.getCategoryId());
//		Status status = dataDelegate.getStatusById(advertise.getStatusId());
		if(opadvertiseEntity.isPresent()) { //Correct PostId
			AdvertiseEntity advertiseEntity = opadvertiseEntity.get();
			advertiseEntity.setTitle(advertise.getTitle());
			advertiseEntity.setPrice(advertise.getPrice());
			advertiseEntity.setDescription(advertise.getDescription());
//			advertiseEntity.setCategory(category.getCategory());
//			advertiseEntity.setStatus(status.getStatus());
			advertiseEntity = advertiesRepository.save(advertiseEntity);

			
//			advertiseEntity = this.modelMapper.map(advertise, AdvertiseEntity.class);
//			advertiseEntity = this.advertiesRepository.save(advertiseEntity);
			Advertise advertiseDto = this.modelMapper.map(advertiseEntity, Advertise.class);
//			return advertiseDto;
			return ResponseEntity.ok(advertiseDto);

		}
		throw new InvalidIdException("" + advertiesID);
	}

	@Override
	public List<Advertise> getAllAdvertiseByLoggedInUser(List<AdvertiseEntity> advertiseEntities) {
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntities) {
			Advertise advertise = this.modelMapper.map(advertiseEntity, Advertise.class);
			advertises.add(advertise);
		}
		return advertises;		
	}

	@Override
	public Advertise getSpecificAdvertiseByLoggedInUser(int postId) {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiesRepository.findById(postId);
		if(opAdvertiseEntity.isPresent()) { //Correct postId
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			Advertise advertiseDto = this.modelMapper.map(advertiseEntity, Advertise.class);
			return advertiseDto;
		}
		return null;
	}

	@Override
	public Boolean DeleteByPostID(int postId) {
		// TODO Auto-generated method stub
//		return null;
		
		
		advertiesRepository.deleteById(postId);
		return true;
	}

	@Override
	public List<Advertise> getAllAdvertiseByFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> getAllAdvertiseByFilterSearchText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertise getAdvertiseDetailsUsingPostID(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
