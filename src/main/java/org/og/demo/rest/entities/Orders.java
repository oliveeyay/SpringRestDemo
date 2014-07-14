package org.og.demo.rest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.og.demo.rest.service.helper.CustomJsonDateDeserializer;
import org.og.demo.rest.service.helper.CustomJsonDateSerializer;

/**
 * Podcast entity
 * 
 * @author Olivier Goutay
 * 
 */
@SuppressWarnings("restriction")
@XmlRootElement
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	/** order */
	@Id
	@GeneratedValue
	@Column(name = "idorder")
	private Long idorder;

	/** Object order */
	@Column(name = "order_object")
	private String order_object;

	/** insertion date in the database */
	@Column(name = "order_date")
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date order_date;

	/** Foreign key for customer id */
	@ManyToOne
	@JoinColumn(name = "fk_customer_id")
	private Customers customer;

	/** Foreign key for restaurant id */
	@ManyToOne
	@JoinColumn(name = "fk_restaurant_id")
	private Restaurants restaurant;

	public Orders() {
	}

	public Orders(String order_object, Date order_date, Customers customer, Restaurants restaurant) {
		this.order_object = order_object;
		this.order_date = order_date;
		this.customer = customer;
		this.restaurant = restaurant;

	}

	public Long getIdorder() {
		return idorder;
	}

	public void setIdorder(Long idorder) {
		this.idorder = idorder;
	}

	public String getOrder_object() {
		return order_object;
	}

	public void setOrder_object(String order_object) {
		this.order_object = order_object;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}

}
