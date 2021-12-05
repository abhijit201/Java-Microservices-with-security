package com.olx.adverties.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.adverties.dto.Advertise;
import com.olx.adverties.service.AdvertiesService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/olx")
public class AdvertisesController {
	
	@Autowired
	@Qualifier("JPA_SERVICE")
	AdvertiesService service;
	
//	List<Advertise> advertises = new ArrayList<Advertise>();
	
	//Local exception
//	@ExceptionHandler(value = {InvalidStockIdException.class})
//	ResponseEntity<Object> handleInvalidStockIdException(RuntimeException exception, WebRequest request){
//		return new ResponseEntity<Object>("Local Exception ", HttpStatus.BAD_REQUEST);
//	} 
	
	//7  Done
	@PostMapping(value = "/advertise", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint create new Adverties")
	public ResponseEntity<?> postNewAdvertise(@RequestBody Advertise advertise, @RequestHeader("auth-token") String authtoken) {
//		advertise= service.postNewAdvertise(advertise, authtoken);
		return service.postNewAdvertise(advertise, authtoken);
	}
	
//	//8
//	@PutMapping(value = "/advertise/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
//			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	@ApiOperation(value = "This REST endpoint update Adverties")
//	public ResponseEntity<Advertise> updateAdvertise(@PathVariable("id") int advertiseId, @RequestBody Advertise advertise, @RequestHeader("auth-token") String authtoken){
//		advertise = service.updateAdvertise(advertiseId, advertise);
//		return new ResponseEntity<Advertise>(advertise,HttpStatus.CREATED);
//	}
	
	//8
	@PutMapping(value = "/advertise/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint update Adverties")
	public ResponseEntity<?> updateAdvertise(@PathVariable("id") int advertiseId, @RequestBody Advertise advertise, @RequestHeader("auth-token") String authtoken){
//		advertise = service.updateAdvertise(advertiseId, advertise, authtoken);
//		return new ResponseEntity(advertise,HttpStatus.CREATED);
		return service.updateAdvertise(advertiseId, advertise, authtoken);
	}
	
	//9 Done
	@GetMapping(value = "/user/advertise", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint get all Adverties by LoggedIn User")
	public List<Advertise> getAllAdvertiseByLoggedInUser(@RequestHeader("auth-token") String authtoken){
		return service.getAllAdvertises();
	}
	
	//10 Done
	@GetMapping(value = "/user/advertise/{postId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint get specific Adverties by LoggedIn User")
	public Advertise getSpecificAdvertiseByLoggedInUser(@PathVariable("postId") int postId, @RequestHeader("auth-token") String authtoken){
		return service.getSpecificAdvertiseByLoggedInUser(postId);
	}
	
	//11 Done
	@DeleteMapping(value = "/user/advertise/{postId}")
	@ApiOperation(value = "This REST endpoint Delete Adverties by LoggedIn User")
	public boolean DeleteByPostID(@PathVariable("postId") int postId, @RequestHeader("auth-token") String authtoken) {
		return service.DeleteByPostID(postId);
	}
	
	//TODO 12
	@GetMapping(value = "/advertise/search/filtercriteria",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint get filtered Adverties")
	public List<Advertise> getAllAdvertiseByFilter(@RequestParam("searchText") String searchText,
												   @RequestParam("category") String category,
												   @RequestParam("postedBy") String postedBy,
												   @RequestParam("dateCondition") String dateCondition,
												   @RequestParam("onDate") String onDate,
												   @RequestParam("fromDate") String fromDate,
												   @RequestParam("toDate") String toDate,
												   @RequestParam("sortBy") String sortBy,
												   @RequestParam("startIndex") String startIndex,
												   @RequestParam("records") String records
												   ){
		return new ArrayList<Advertise>();
	}
	
	//TODO 13
	@GetMapping(value = "/advertise/search",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint get byFilterSearchText Adverties")
	public List<Advertise> getAllAdvertiseByFilterSearchText(@RequestParam("searchText") String searchText){
		return new ArrayList<Advertise>();
	}
	
	//14
	@GetMapping(value = "/advertise/{postId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "This REST endpoint get specific Adverties Details by LoggedIn User")
	public Advertise getAdvertiseDetailsUsingPostID(@PathVariable("postId") int postId, @RequestHeader("auth-token") String authtoken){
		return service.getAdvertiseDetailsUsingPostID(postId);
	}
	

}
