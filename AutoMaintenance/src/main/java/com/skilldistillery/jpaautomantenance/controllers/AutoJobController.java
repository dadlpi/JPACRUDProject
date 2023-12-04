package com.skilldistillery.jpaautomantenance.controllers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpaautomantenance.data.AutoJobDAO;
import com.skilldistillery.jpaautomantenance.entities.AutoJob;

@Controller
public class AutoJobController {

	@Autowired
	private AutoJobDAO autoJobDao;

	@RequestMapping(path = { "/", "home.do" })
	public String index(Model model) {
		model.addAttribute("autoJobList", autoJobDao.findAll());
		return "home";
	}

	@RequestMapping(path = "GetIndividualJob.do", params = "jobId", method = RequestMethod.GET)
	public String showOneJob(@RequestParam("jobId") int jobId, Model model) {
		AutoJob autoJob = autoJobDao.findById(jobId);
		model.addAttribute("individualJob", autoJob);
		 return "individualJob";
	}
	
	
	@RequestMapping(path = "CreateJob.do", params = {"name", "interval"}, method = RequestMethod.GET)
	public ModelAndView createJob(@RequestParam("name") String jobName, @RequestParam("interval") int jobInterval ) {
		ModelAndView mv = new ModelAndView();
		AutoJob autoJob = new AutoJob();
		autoJob.setNameOfJob(jobName);
		autoJob.setIntervalBetweenJob(jobInterval);
		autoJob.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		autoJob.setCreatorId("AMA_APP");
		autoJob.setActiveInd("Y");
		autoJob = autoJobDao.create(autoJob);
		
		mv.addObject("autoJobList", autoJobDao.findAll());
		
		mv.setViewName("home");
		return mv;
	}
	
	
	@RequestMapping(path = "deleteJob.do", params = "jobId", method = RequestMethod.POST)
	public String deleteOneJob(@RequestParam("jobId") int jobId, Model model) {
		Boolean returnedValue = autoJobDao.delete(jobId);
		model.addAttribute("autoJobList", autoJobDao.findAll());
		return "home";
	}
	
	//Ask Why this one as a Get did not work
	@RequestMapping(path = "updateForm.do", params = "theJobId", method = RequestMethod.POST)
	public String updateForm(@RequestParam("theJobId") int jobId, Model model) {
//		System.out.println("we are hitting variable " + jobId);
//		ModelAndView mv = new ModelAndView();
		AutoJob autoJob = autoJobDao.findById(jobId);
		model.addAttribute("individualJob", autoJob);
//		mv.setViewName("updateForm");
		return "updateForm";
		
	}
	
	
	@RequestMapping(path = "update.do", params = {"jobId", "radioValue", "description"}, method = RequestMethod.POST)
	public String update(@RequestParam("jobId") int jobId, @RequestParam("radioValue") String activeInd, @RequestParam("description") String description, Model model) {
//		System.out.println("jobId:" + jobId );
//		System.out.println("radioValue:" + activeInd);
//		System.out.println("description:" + description);
		AutoJob anAutoJob = new AutoJob();
		anAutoJob.setId(jobId);
		anAutoJob.setActiveInd(activeInd);
		anAutoJob.setDescription(description);
		
		
		AutoJob changedJob = autoJobDao.udpdate(jobId, anAutoJob);
		
		//Find the individual job after update
		AutoJob autoJob = autoJobDao.findById(changedJob.getId());
		model.addAttribute("individualJob", autoJob);
		 return "individualJob";
	}
	
	

}
