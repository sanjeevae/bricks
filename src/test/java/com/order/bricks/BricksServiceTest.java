package com.order.bricks;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.order.bricksservice.BricksService;
import com.order.model.BricksResponse;

import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class BricksServiceTest {
	
	 @Tested
	 BricksService bricksService;
	 
	 @Test
	 public void testCreateOrder() {
		 
		 BricksResponse  response = bricksService.orderBricks(22);
		 Assert.assertNotNull("response should not be null",response);
		 
	 }
	 
	 @Test
	 public void testUpdateOrder() {
		 
		 BricksResponse  response = bricksService.updateOrderBricks(2, "23");
		 Assert.assertNotNull("response should not be null",response);
		 
	 }
	 
	 @Test
	 public void testGetOrderInfo() {
		 
		 BricksResponse  response = bricksService.getBricksOrderIndo("2");	
		 Assert.assertNotNull("response should not be null",response);
		 
	 }
	 
	 @Test
	 public void testGetAllOrderInfo() {
		 
		 List<BricksResponse>  response = bricksService.getAllBricksOrderIndo();
		 Assert.assertNotNull("response should not be null",response);
		 
	 }
	 
	 @Test
	 public void testDispatchOrder() {
		 
		 BricksResponse  response = bricksService.dispatchBricksOrder("2");
		 Assert.assertNotNull("response should not be null",response);
		 
	 }
	 

}
