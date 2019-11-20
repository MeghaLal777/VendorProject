package com.ust.model;

public class Vendor {

	// instance variables

	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String location;
	private String service;
	private int pincode;
	private String isActive;

	// default constructor

	public Vendor() {
		super();

	}

	// parameterized constructor

	public Vendor(int vendorId, String vendorName, String vendorAddress,
			String location, String service, int pincode, String isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
	}

	// getters and setters

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
