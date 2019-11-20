package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorPerson;

public class VendorPersonDao implements IVendorPersonDao {
	
 //connection establishment with the database	
	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
	// Insert vendor
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#vendorInsert(com.ust.model.VendorPerson)
	 */
	@Override
	public int vendorInsert(VendorPerson bean) {
	String sql = "insert into UST_VendorTable(vendorName,vendorAddress,location,service,pincode,isActive) values(?,?,?,?,?,1)";
	template.update(sql, new Object[] { bean.getVendorName(), bean.getVendorAddress(),
	bean.getLocation(), bean.getService(), bean.getPincode() });

	String sql1 = "select max(vendorId) from UST_VendorTable";
	int vendorId = template.queryForObject(sql1, Integer.class);
	String sql2 = "insert into UST_PersonTable(vendorId,contactName,department,email,phone) values(?,?,?,?,?)";
	return template.update(
	sql2,
	new Object[] { vendorId, bean.getContactName(),bean.getDepartment(),
	bean.getEmail(),bean.getPhone() });

	}

	//View vendor details
	
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#vendorList()
	 */
	@Override
	public List<VendorPerson> vendorList() {
	return template
	.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) where isActive!='0'",
	new RowMapper<VendorPerson>() {

	@Override
	public VendorPerson mapRow(ResultSet rs, int row)
	throws SQLException {
	// TODO Auto-generated method stub

	VendorPerson bean = new VendorPerson();
	bean.setVendorId(rs.getInt(1));
	bean.setVendorName(rs.getString(2));
	bean.setVendorAddress(rs.getString(3));
	bean.setLocation(rs.getString(4));
	bean.setService(rs.getString(5));
	bean.setPincode(rs.getInt(6));
	bean.setIsActive(rs.getString(7));
	bean.setContactId(rs.getInt(8));
	bean.setContactName(rs.getString(9));
	bean.setDepartment(rs.getString(10));
	bean.setEmail(rs.getString(11));
	bean.setPhone(rs.getString(12));
	return bean;
	}
	});

	}

	//Edit vendor details
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#updatevendor(com.ust.model.VendorPerson)
	 */
	@Override
	public int updatevendor(VendorPerson bean)
	{
	String sql="update UST_VendorTable set vendorName=?,vendorAddress=?,location=?,service=?,pincode=?,isActive=? where vendorId=?";
	template.update(sql,new Object[] {bean.getVendorName(),bean.getVendorAddress(),bean.getLocation(),bean.getService(),bean.getPincode(),bean.getIsActive(),bean.getVendorId()});
	String sql1="update UST_PersonTable set contactName=?,department=?,email=?,phone=? where contactId=?";
	return template.update(sql1, new Object[] {bean.getContactName(),bean.getDepartment(),bean.getEmail(),bean.getPhone(),bean.getContactId()});
	}


	//Disable vendor
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#disableVendor(int)
	 */
	@Override
	public int disableVendor(int vendorId) {
	   String sql = "update UST_VendorTable set isActive = '0'  where vendorId = '" + vendorId + "'";
	   return template.update(sql);
	   }

	//Search
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#vendorSearch(java.lang.String)
	 */
	@Override
	public List<VendorPerson> vendorSearch(String search) {
	return template
	.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) where location like'"
	+ search + "%' or vendorName like'" + search + "%' or service like'" + search + "%'"  ,
	new RowMapper<VendorPerson>() {

	@Override
	public VendorPerson mapRow(ResultSet rs, int row)
	throws SQLException {
	VendorPerson bean = new VendorPerson();
	bean.setVendorId(rs.getInt(1));
	bean.setVendorName(rs.getString(2));
	bean.setVendorAddress(rs.getString(3));
	bean.setLocation(rs.getString(4));
	bean.setService(rs.getString(5));
	bean.setPincode(rs.getInt(6));
	bean.setIsActive(rs.getString(7));
	bean.setContactId(rs.getInt(8));
	bean.setContactName(rs.getString(9));
	bean.setDepartment(rs.getString(10));
	bean.setEmail(rs.getString(11));
	bean.setPhone(rs.getString(12));
	return bean;
	}

	});
	}

	//Sort by vendorId
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#sortListA()
	 */
	@Override
	public List<VendorPerson> sortListA() {
	return template
	.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) order by vendorId",
	new RowMapper<VendorPerson>() {

	@Override
	public VendorPerson mapRow(ResultSet rs, int row)
	throws SQLException {
	// TODO Auto-generated method stub

	VendorPerson bean = new VendorPerson();
	bean.setVendorId(rs.getInt(1));
	bean.setVendorName(rs.getString(2));
	bean.setVendorAddress(rs.getString(3));
	bean.setLocation(rs.getString(4));
	bean.setService(rs.getString(5));
	bean.setPincode(rs.getInt(6));
	bean.setIsActive(rs.getString(7));
	bean.setContactId(rs.getInt(8));
	bean.setContactName(rs.getString(9));
	bean.setDepartment(rs.getString(10));
	bean.setEmail(rs.getString(11));
	bean.setPhone(rs.getString(12));
	return bean;
	}
	});

	}

	//Sort by vName
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#sortListB()
	 */
	@Override
	public List<VendorPerson> sortListB() {
	return template
	.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) order by vendorName",
	new RowMapper<VendorPerson>() {

	@Override
	public VendorPerson mapRow(ResultSet rs, int row)
	throws SQLException {
	// TODO Auto-generated method stub

	VendorPerson bean
    = new VendorPerson();
	bean.setVendorId(rs.getInt(1));
	bean.setVendorName(rs.getString(2));
	bean.setVendorAddress(rs.getString(3));
	bean.setLocation(rs.getString(4));
	bean.setService(rs.getString(5));
	bean.setPincode(rs.getInt(6));
	bean.setIsActive(rs.getString(7));
	bean.setContactId(rs.getInt(8));
	bean.setContactName(rs.getString(9));
	bean.setDepartment(rs.getString(10));
	bean.setEmail(rs.getString(11));
	bean.setPhone(rs.getString(12));
	return bean;
	}
	});

	}
	
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorPersonDao#getById(int)
	 */
	@Override
	public List<VendorPerson> getById(int vendorId) {
		return template
		.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) where vendorId= "
		+ vendorId + "", new RowMapper<VendorPerson>() {
		public VendorPerson mapRow(ResultSet rs, int row)
		throws SQLException {
			VendorPerson bean
		    = new VendorPerson();
			bean.setVendorId(rs.getInt(1));
			bean.setVendorName(rs.getString(2));
			bean.setVendorAddress(rs.getString(3));
			bean.setLocation(rs.getString(4));
			bean.setService(rs.getString(5));
			bean.setPincode(rs.getInt(6));
			bean.setIsActive(rs.getString(7));
			bean.setContactId(rs.getInt(8));
			bean.setContactName(rs.getString(9));
			bean.setDepartment(rs.getString(10));
			bean.setEmail(rs.getString(11));
			bean.setPhone(rs.getString(12));
			return bean;
			}
			});
		}

	}
	


