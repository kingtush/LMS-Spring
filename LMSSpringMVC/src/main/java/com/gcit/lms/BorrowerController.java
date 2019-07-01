package com.gcit.lms;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcit.lms.service.AdminService;
import com.gcit.lms.service.BorrowerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BorrowerController {
	
	@Autowired 
	BorrowerService borrowerService;
	
	@RequestMapping(value = "/borrower", method = RequestMethod.GET)
	public String lmsHome(Locale locale, Model model) throws SQLException {
		//model.addAttribute("sizeofborrowers", adminService.readAllBorrowers().size());		
		return "lmsborrower";
	}
	
	
}
