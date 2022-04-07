package com.apicrud.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apicrud.demo.bean.UserBean;

@Repository
public class UserDao 
{
		
		@Autowired
	    JdbcTemplate stmt;
	
		
		public Object addUser() //done
		{
			stmt.update("insert into users (userid,username) values (8,'AddedBySpringUser') ");
			System.out.println("User created Successfully");
			return addUser();
		}  
		
		public Object deleteUser() //done
		{
			stmt.update("delete from users where username = 'Prachi'");
			System.out.println("User Deleted Successfully");
			return deleteUser();
		}
		
		public Object updateUser() //done
		{
			stmt.update("update users set username = 'UpdatedUserName3' where userid = 3");
			System.out.println("User Updated Successfully");
			return updateUser();
		}

		
		public List<UserBean> listUser() 
		{
		  List<UserBean> users = stmt.query("SELECT * FROM public.users", new BeanPropertyRowMapper<UserBean>(UserBean.class));

		    return users;
		}
		public List<UserBean> getTable()
		{
	        List<UserBean> customers = stmt.query("SELECT * FROM public.users",new BeanPropertyRowMapper<>(UserBean.class));

	        return customers;
	    }
		  

	}  
	  
