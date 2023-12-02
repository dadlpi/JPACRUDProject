package com.skilldistillery.jpaautomantenance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpaautomantenance.data.AutoJobDAO;

@Controller
public class AutoJobController {
	
	@Autowired
	private AutoJobDAO autoJobDao;
	
	@RequestMapping( path = {"/", "home.do"} )
	public String index(Model model) {
		model.addAttribute("autoJobList", autoJobDao.findAll() );
		return "home";
	}

}
