package org.og.demo.rest.dao;

import java.util.List;

import org.og.demo.rest.entities.Orders;

/**
 * 
 * @author Olivier Goutay
 */
public interface OrderDao {

	public List<Orders> getOrders();

	/**
	 * Returns a Order given its id
	 * 
	 * @param id
	 * @return
	 */
	public Orders getOrderById(Long id);

	public Long deleteOrderById(Long id);

	public Long createOrder(Orders order);

	public int updateOrder(Orders order);

	/** removes all Orders */
	public void deleteOrders();

}
