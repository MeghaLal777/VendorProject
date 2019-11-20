package com.ust.dao;

import java.util.List;

import com.ust.model.VendorPerson;

public interface IVendorPersonDao {

	public abstract int vendorInsert(VendorPerson bean);

	public abstract List<VendorPerson> vendorList();

	//Edit vendor details
	public abstract int updatevendor(VendorPerson bean);

	//Disable vendor
	public abstract int disableVendor(int vendorId);

	//Search
	public abstract List<VendorPerson> vendorSearch(String search);

	//Sort by vendorId
	public abstract List<VendorPerson> sortListA();

	//Sort by vName
	public abstract List<VendorPerson> sortListB();

	public abstract List<VendorPerson> getById(int vendorId);

}