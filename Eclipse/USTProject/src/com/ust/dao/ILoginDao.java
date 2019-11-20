package com.ust.dao;

import com.ust.model.Login;

public interface ILoginDao {

	public abstract Login LoginChecker(String username, String password);

}