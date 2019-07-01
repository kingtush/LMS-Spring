package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.LibraryBranch;

@RestController
public class LibrarianService {
	
	@Autowired
	BookDAO bdao;

	@Autowired
	AuthorDAO adao;
	
	@Autowired
	BranchDAO brdao;
	
	@Autowired
	GenreDAO gdao;
	
	@Autowired
	PublisherDAO pdao;
	
	@Autowired
	BookCopiesDAO bcdao;
	
	@Autowired
	BorrowerDAO borrowdao;
	
	@Autowired
	BookLoansDAO bldao;
	
	@RequestMapping(value= "/updateBranchName", method=RequestMethod.POST, consumes="application/json")
	public void updateBranch(@RequestBody LibraryBranch branch) throws SQLException, ClassNotFoundException {
		
		
		try {
			if(branch.getBranchName()==null && branch.getBranchAddress()==null) {
				
				System.out.println("Update Failed. No New details added.");
				throw new IllegalArgumentException();
			}
			else {
				brdao.updateLibraryBranch(branch);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Something went wrong. Failed to add publisher");
		} finally {
			System.out.println("Finally");
			}
		}
	
	@RequestMapping(value= "/addCopies", method=RequestMethod.POST, consumes="application/json")
	public void addCopies(@RequestBody BookCopies bookCopies) throws SQLException, ClassNotFoundException {
		
		
		try {
			if(bookCopies.getBookId()==null || bookCopies.getBranchId()==null || bookCopies.getNoOfCopies()==null) {
				bcdao.updateBookCopies(bookCopies);
				throw new IllegalArgumentException();

			}
			else {
				bcdao.updateBookCopies(bookCopies);
				//throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Something went wrong. Failed to add COPIES");
		} finally {
			System.out.println("Finally");
			}
		}
	
}

	

/*LIBRARIAN-COMPLETED
 * Update branch details-name and address
 * add copies of existing book to branch
 */
