package org.og.demo.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Customer entity
 * 
 * @author Olivier Goutay
 * 
 */
@SuppressWarnings("restriction")
@XmlRootElement
@Entity
@Table(name = "customers")
public class Customers implements Serializable {

	private static final long serialVersionUID = 525313427114562417L;

	/** id of the account */
	@Id
	@GeneratedValue
	@Column(name = "idcustomer")
	private Long idcustomer;

	/** customer's name */
	@Column(name = "customer_name")
	private String customer_name;

	/** customer's surname */
	@Column(name = "customer_surname")
	private String customer_surname;

	/** customer's address */
	@Column(name = "customer_address")
	private String customer_address;

	public Customers() {
	}

	public Customers(String customer_name, String customer_surname, String customer_address) {

		this.customer_name = customer_name;
		this.customer_surname = customer_surname;
		this.customer_address = customer_address;

	}

	public Long getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Long idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_surname() {
		return customer_surname;
	}

	public void setCustomer_surname(String customer_surname) {
		this.customer_surname = customer_surname;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

}
