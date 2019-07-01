package com.gcit.lms.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;

@RestController
public class BorrowerService {

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
	
	
	@RequestMapping(value= "/returnLoan", method=RequestMethod.POST, consumes="application/json")
	public void returnBook(@RequestBody BookLoans bookLoan) throws SQLException, ClassNotFoundException  {
		System.out.println("Returning Book");
		try {

			if(bookLoan.getBookId()==null || bookLoan.getBorrowerId()==null || bookLoan.getBranchId()==null) {
				throw new IllegalArgumentException();
			}

			bldao.updateBookLoan(bookLoan);
			bldao.updateAddCopies(bookLoan);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Something went wrong. Failed to get all branches");
		} finally {

			// System.out.println("Done Reading fam");
		}
	}
	
	@RequestMapping(value= "/addLoan", method=RequestMethod.POST, consumes="application/json")
	public void addLoan(@RequestBody BookLoans bookloan)
			throws SQLException, ClassNotFoundException {
		bookloan.setBorrowerId(bookloan.getBorrowerId());
		bookloan.setBranchId(bookloan.getBranchId());
		bookloan.setBookId(bookloan.getBookId());
		try {
			if(bookloan.getBookId()==null || bookloan.getBorrowerId()==null || bookloan.getBranchId()==null) {
				throw new NullPointerException();
			}
			else{
			bldao.addBookLoan(bookloan);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Something went wrong. Failed to add loan");
		} finally {

		}
		
		System.out.println("Successfully borrowed book");
	}
	
}
	

/*basic requirements completed (somewhat)
 * 
 */

