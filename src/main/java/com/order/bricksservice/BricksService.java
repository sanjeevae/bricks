package com.order.bricksservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Singleton;

import com.order.model.BricksResponse;

@Singleton
public class BricksService {
	
	private int bricksUnique = 1;
	private Map<Integer, Integer> bricksMap =  new HashMap<Integer,Integer>();
	private Map<Integer, Integer>  bricksDispatchMap  = new HashMap<Integer, Integer>();

	public int getBricksUnique() {
		return bricksUnique++;
	}

	public void setBricksUnique(int bricksUnique) {
		this.bricksUnique = bricksUnique;
	}
	
	
	public BricksResponse orderBricks(Integer numOfBricks) {
		
		BricksResponse response =  new BricksResponse();
		
				
		Integer bricksId = getBricksUnique();
		
		bricksMap.put(bricksId, numOfBricks);
		
		response.setBricksOrderId(bricksId);
		response.setNumOfBricks(String.valueOf(numOfBricks));
		
		return response;
		
		
	}
	
public BricksResponse updateOrderBricks(Integer numOfBricks, String brOrderId) {
		
		BricksResponse response =  new BricksResponse();
		
				
		if(bricksDispatchMap.containsKey(Integer.valueOf(brOrderId))) {
			return null;
		}
		
		bricksMap.put(Integer.valueOf(brOrderId), numOfBricks);
		
		response.setBricksOrderId(Integer.valueOf(brOrderId));
		response.setNumOfBricks(String.valueOf(numOfBricks));
		
		return response;
		
		
	}
	
	public BricksResponse getBricksOrderIndo(String brorderId) {
		
		BricksResponse response =  new BricksResponse();
		response.setBricksOrderId(Integer.valueOf(brorderId));
		response.setNumOfBricks(String.valueOf(bricksMap.get(Integer.valueOf(brorderId))));
		
		return response;
		
	}
	
public List<BricksResponse> getAllBricksOrderIndo() {
	
		List<BricksResponse> bricksResponseList =  new ArrayList<BricksResponse>();
	
		for(Entry entry: bricksMap.entrySet()) {
		
			BricksResponse response =  new BricksResponse();
			response.setBricksOrderId((Integer)(entry.getKey()));
			response.setNumOfBricks(String.valueOf(entry.getValue()));
			bricksResponseList.add(response);
		}
		return bricksResponseList;
		
	}

public BricksResponse dispatchBricksOrder(String brorderId) {
	
	BricksResponse response =  new BricksResponse();
	response.setBricksOrderId(Integer.valueOf(brorderId));
	response.setNumOfBricks(String.valueOf(bricksMap.get(Integer.valueOf(brorderId))));
	
	bricksDispatchMap.put(Integer.valueOf(brorderId), bricksMap.get(Integer.valueOf(brorderId)));
	
	bricksMap.remove(Integer.valueOf(brorderId));
	
	
	
	return response;
	
}
	

}
