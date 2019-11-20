package com.ust.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.Login;


public class LoginDao implements ILoginDao {

	
//connection establishment with the database
	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	
	
	// method to check if the userName and password is valid or not
	
	/* (non-Javadoc)
	 * @see com.ust.dao.ILoginDao#LoginChecker(java.lang.String, java.lang.String)
	 */
	@Override
	public Login LoginChecker(String username,String password)
	{
		Login login = new Login();
		
		String sql = "select userId,userName,password from UST_LoginTable where userName = ? and password = ?";
		try
		{
			login =  (Login) template.queryForObject(sql,new Object[] {username,password},
					new BeanPropertyRowMapper<Login>(Login.class));	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return login;
	}
}
