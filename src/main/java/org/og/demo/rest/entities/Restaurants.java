package org.og.demo.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Restaurant entity
 * 
 * @author Olivier Goutay
 * 
 */
@SuppressWarnings("restriction")
@XmlRootElement
@Entity
@Table(name = "restaurants")
public class Restaurants implements Serializable {

	private static final long serialVersionUID = 8602028825053716760L;

	/** id of the restaurant */
	@Id
	@GeneratedValue
	@Column(name = "idrestaurant")
	private Long idrestaurant;

	/** restaurant's name */
	@Column(name = "restaurant_name")
	private String restaurant_name;

	/** restaurant's address */
	@Column(name = "restaurant_address")
	private String restaurant_address;

	public Restaurants() {
	}

	public Restaurants(String restaurant_name, String restaurant_address) {

		this.restaurant_name = restaurant_name;
		this.restaurant_address = restaurant_address;

	}

	public Long getIdrestaurant() {
		return idrestaurant;
	}

	public void setIdrestaurant(Long idrestaurant) {
		this.idrestaurant = idrestaurant;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

}
