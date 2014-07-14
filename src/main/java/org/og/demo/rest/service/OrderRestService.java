package org.og.demo.rest.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.og.demo.rest.dao.OrderDao;
import org.og.demo.rest.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Service class that handles REST requests
 * 
 * @author Olivier Goutay
 * 
 */
@Component
@Path("/orders")
public class OrderRestService {

	@Autowired
	private OrderDao orderDao;

	/************************************ CREATE ************************************/

	/**
	 * Adds a new resource (order) from the given json format (at least title
	 * and feed elements are required at the DB level)
	 * 
	 * @param order
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response createOrder(Orders order) {
		orderDao.createOrder(order);

		return Response.status(201).entity("A new order/resource has been created").build();
	}

	/************************************ READ ************************************/
	/**
	 * Returns all resources (orders) from the database
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Orders> getOrders() throws JsonGenerationException, JsonMappingException, IOException {

		List<Orders> orders = orderDao.getOrders();

		return orders;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Long id) throws JsonGenerationException, JsonMappingException, IOException {

		Orders orderById = orderDao.getOrderById(id);

		if (orderById != null) {
			return Response.status(200).entity(orderById).header("Access-Control-Allow-Headers", "X-extra-header").allow("OPTIONS").build();
		} else {
			return Response.status(404).entity("The order with the id " + id + " does not exist").build();
		}
	}

	/************************************ UPDATE ************************************/
	/**
	 * Updates the attributes of the order received via JSON for the given @param
	 * id
	 * 
	 * If the order does not exist yet in the database (verified by
	 * <strong>id</strong>) then the application will try to create a new order
	 * resource in the db
	 * 
	 * @param id
	 * @param order
	 * @return
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response updateOrderById(Orders order) {
		String message;
		int status;
		if (order.getIdorder() != null) {
			orderDao.updateOrder(order);
			status = 200; // OK
			message = "Order has been updated";
		} else {
			status = 406; // Not acceptable
			message = "The information you provided is not sufficient to perform either an UPDATE or "
					+ " an INSERTION of the new order resource <br/>"
					+ " If you want to UPDATE please make sure you provide an existent <strong>id</strong> <br/>";
		}

		return Response.status(status).entity(message).build();
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response deleteOrderById(@PathParam("id") Long id) {
		if (orderDao.deleteOrderById(id) == 1) {
			return Response.status(204).build();
		} else {
			return Response.status(404).entity("Order with the id " + id + " is not present in the database").build();
		}
	}

	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response deleteOrders() {
		orderDao.deleteOrders();
		return Response.status(200).entity("All orders have been successfully removed").build();
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
