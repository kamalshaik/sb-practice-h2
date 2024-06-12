package com.skh.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String doorNo;
	private String street;
	private String city;
	private String state;
	private Integer pinNo;

	public Address() {

	}

	public Address(Integer id, String doorNo, String street, String city, String state, Integer pinNo) {
		this.id = id;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinNo = pinNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinNo() {
		return pinNo;
	}

	public void setPinNo(Integer pinNo) {
		this.pinNo = pinNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, doorNo, id, pinNo, state, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(doorNo, other.doorNo) && Objects.equals(id, other.id)
				&& Objects.equals(pinNo, other.pinNo) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pinNo=" + pinNo + "]";
	}

}
