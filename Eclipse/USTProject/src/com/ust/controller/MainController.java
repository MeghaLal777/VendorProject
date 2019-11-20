package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.ILoginDao;
import com.ust.dao.IVendorPersonDao;
import com.ust.model.Login;
import com.ust.model.VendorPerson;



@RestController
public class MainController
{
	//
	
	@Autowired
	ILoginDao lDao;
	
	@Autowired
	IVendorPersonDao vpDao;
	

/******************************AUTHENTICATING USER*****************************************/

	   //Login checker
	
		@RequestMapping(value = "/api/login/{userName}/{password}", method = RequestMethod.GET)
		
		public Login getRole(@PathVariable("userName") String userName,@PathVariable("password") String password)
		{
			return lDao.LoginChecker(userName, password);
		}

/*************************************SERVICES***************************************************/
		
		
		
		//View details of vendor
		
		@RequestMapping(value="/api/vendor/vendordetails",method=RequestMethod.GET,headers = "Accept=application/json")
		public List vendorView()
		{
		List list=vpDao.vendorList();
		return list;
		}

		//Search method
		
		@RequestMapping(value="/api/vendor/{search}",method=RequestMethod.GET,headers = "Accept=application/json")
		public List viewsearch(@PathVariable("search") String search)
		{
		List list=vpDao.vendorSearch(search);
		return list;
		}

		//Add or update details of vendor
		
		@RequestMapping(value="/api/vendor/add",method={RequestMethod.POST,RequestMethod.PUT})
		public void insertProduct(@RequestBody VendorPerson bean)
		{
		if(bean.getVendorId()==0)
		{
			vpDao.vendorInsert(bean);
		}
		else
		{
			vpDao.updatevendor(bean);
		}

		}

		//Disabling vendor
		
		@RequestMapping(value = "/api/vendor/disablevendor/{vendorId}", method = RequestMethod.PUT)
		public void staffDisable(@PathVariable("vendorId") int vendorId) {
			vpDao.disableVendor(vendorId);
		}


		//Sort by vendorId
		
		@RequestMapping(value="/api/vendor/vendordetails/sortbyid",method=RequestMethod.GET,headers = "Accept=application/json")
		public List sortById()
		{
		List list=vpDao.sortListA();
		return list;
		}


		//Sort by vendorName
		
		@RequestMapping(value="/api/vendor/vendordetails/sortbyname",method=RequestMethod.GET,headers = "Accept=application/json")
		public List sortByName()
		{
		List list=vpDao.sortListB();
		return list;
		}
		
		// TO RETRIVE A VENDOR BY HIS ID

		@RequestMapping(value = "/api/vendor/view/{vendorId}", method = RequestMethod.GET, headers = "Accept=application/json")
		public VendorPerson getById(
		@ModelAttribute("bean") VendorPerson bean,
		@PathVariable("vendorId") int vendorId) {
		List list = vpDao.getById(vendorId);
		bean = (VendorPerson) list.get(0);
		return bean;
		}
		


		}

	


