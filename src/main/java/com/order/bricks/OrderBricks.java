package com.order.bricks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.order.bricksservice.BricksService;
import com.order.model.BricksResponse;

@Path("/bricks")
public class OrderBricks {
	
	private BricksService bricksService = new BricksService(); 
	
	
	@POST
	@Path("/createorder")
    public Response saveOrderBricks(@PathParam("bricks")String numOfBricks, 
                                  @Context HttpServletRequest servletRequest) {
		Response response;
		BricksResponse brresponse  =  bricksService.orderBricks(Integer.valueOf(numOfBricks));
		response = Response.ok(brresponse).type(MediaType.APPLICATION_JSON_TYPE).build();
		
		return response;
		
		
		
	}
	
	@POST
	@Path("/updateorder")
    public Response updateOrderBricks(@PathParam("bricks")String numOfBricks, 
    								@PathParam("bricksOrderId")String bricksOrderId) {
		Response response;
		BricksResponse brresponse  =  bricksService.updateOrderBricks(Integer.valueOf(numOfBricks), bricksOrderId);
		response = Response.ok(brresponse).type(MediaType.APPLICATION_JSON_TYPE).build();
		
		return response;
		
		
		
	}
	
	@POST
	@Path("/dispatchorder")
    public Response dispatchOrderBricks(@PathParam("bricksOrderId")String bricksOrderId) {
		Response response;
		BricksResponse brresponse  =  bricksService.dispatchBricksOrder(bricksOrderId);
		response = Response.ok(brresponse).type(MediaType.APPLICATION_JSON_TYPE).build();
		
		return response;
		
		
		
	}
	
	@GET
	@Path("/getorderinfo")
	public  Response getBricksOrderInfo(@PathParam("bricksOrderId")String bricksOrderId) {
		Response response;
		
		BricksResponse brresponse  =  bricksService.getBricksOrderIndo(bricksOrderId);
		response = Response.ok(brresponse).type(MediaType.APPLICATION_JSON_TYPE).build();
		return response;
		
	}
	
	@GET
	@Path("/getallorderinfo")
	public  Response getAllBricksOrderInfo() {
		Response response;
		
		List<BricksResponse> brresponse  =  bricksService.getAllBricksOrderIndo();
		response = Response.ok(brresponse).type(MediaType.APPLICATION_JSON_TYPE).build();
		return response;
		
	}
	
	
        
                                  

}
