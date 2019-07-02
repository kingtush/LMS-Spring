/**
 * 
 */
package com.gcit.lms;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.service.AdminService;
import com.gcit.lms.service.BorrowerService;
import com.gcit.lms.service.LibrarianService;

/**
 * @author ppradhan
 *
 */
@Configuration
public class LMSConfig {
	
	public String driverName = "com.mysql.cj.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/library?useSSL=true&serverTimezone=UTC";
	public String username = "root";
	public String password = "kingtush7";
	
	
	@Bean
//	@Scope(value="prototype")
	public BasicDataSource mysqlDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setDefaultAutoCommit(Boolean.FALSE);
		return ds;
	}

	@Bean
	@Qualifier(value="mysqlTemplate")
	public JdbcTemplate mysqlTemplate(){
		return new JdbcTemplate(mysqlDataSource());
	}
	
	@Bean
//	@Scope(value="prototype")
	public BasicDataSource oracleDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	@Qualifier(value="oracleTemplate")
	public JdbcTemplate oracleTemplate(){
		return new JdbcTemplate(oracleDataSource());
	}
	
	@Bean
	public BookDAO bdao(){
		return new BookDAO();
	}
	
	@Bean
	public AuthorDAO adao(){
		return new AuthorDAO();
	}
	
	@Bean
	public GenreDAO gdao(){
		return new GenreDAO();
	}
	
	@Bean
	public PublisherDAO pdao(){
		return new PublisherDAO();
	}
	
	@Bean
	public BorrowerDAO borrowdao(){
		return new BorrowerDAO();
	}
	
	@Bean
	public BookCopiesDAO copiesdao(){
		return new BookCopiesDAO();
	}
	
	@Bean
	public BookLoansDAO loansdao(){
		return new BookLoansDAO();
	}
	
	@Bean
	public BranchDAO branchdao(){
		return new BranchDAO();
	}
	
	@Bean
	public AdminService adminService(){
		return new AdminService();
	}
	
//	@Bean
//	public BorrowerService borrowService() {
//		return new BorrowerService();
//	}
//	
//	@Bean
//	public LibrarianService librarianService() {
//		return new LibrarianService();
//	}
	//all daos
	
	@Bean
	DataSourceTransactionManager txManager(){
		return new DataSourceTransactionManager(mysqlDataSource());
	}
}
