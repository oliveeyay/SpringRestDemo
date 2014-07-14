package org.og.demo.rest.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.og.demo.rest.dao.OrderDao;
import org.og.demo.rest.entities.Orders;

public class OrderDaoImpl implements OrderDao {

	@PersistenceContext(unitName = "demoRestPersistenceLegacy")
	private EntityManager entityManager;

	public List<Orders> getOrders() {

		String qlString = "SELECT p FROM Orders p";
		TypedQuery<Orders> query = entityManager.createQuery(qlString, Orders.class);

		return query.getResultList();
	}

	public Orders getOrderById(Long id) {

		try {
			String qlString = "SELECT p FROM Orders p WHERE p.id = ?1";
			TypedQuery<Orders> query = entityManager.createQuery(qlString, Orders.class);
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Long deleteOrderById(Long id) {

		Orders order = entityManager.find(Orders.class, id);
		entityManager.remove(order);

		return 1L;
	}

	public Long createOrder(Orders order) {

		order.setOrder_date(new Date());
		entityManager.persist(order);
		entityManager.flush();// force insert to receive the id of the order

		return order.getIdorder();
	}

	public int updateOrder(Orders order) {

		entityManager.merge(order);

		return 1;
	}

	public void deleteOrders() {
		Query query = entityManager.createNativeQuery("TRUNCATE TABLE orders");
		query.executeUpdate();
	}

}
