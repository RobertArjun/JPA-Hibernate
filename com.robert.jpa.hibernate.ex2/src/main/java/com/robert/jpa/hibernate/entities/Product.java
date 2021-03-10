package com.robert.jpa.hibernate.entities;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "product")
public class Product {

	@Id // Mandatory to add ID annotation
	/** 1. GenerationType.IDENTITY
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) // if table column is Auto increment then Identity strategy will
	// automatically create the the id so Auto increment should be enable in the
	// table
	 */
	/**
	 * 2.1
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
	key_generator is a table name so this table should have two column name such as
	sequence_name and next_val so while executing the persist or save hibernate will automatically create the sequence
	**/
	/**@TableGenerator(name = "key_generator",
	table = "key_generator", pkColumnName = "key_name", pkColumnValue = "product_sequence", valueColumnName = "key_value")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
	TableGenerator annotation is used to create custom table and custom column name
	*/
	private int id;

	@Basic(optional = false)
	private String name;

	private double price;

	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

}
