package org.slevin.controller;

import org.slevin.common.Aves;
import org.slevin.dao.AvesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/aves")
public class AvesController {

	@Autowired
    AvesDao avesService;
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllAvesView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/aves/showAllAves");
	  List<Aves> aves = avesService.findAll();
	  mav.addObject("aves", aves);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newAvesForm()
	 {
	  ModelAndView mav = new ModelAndView("/aves/newAves");
	  Aves aves = new Aves();
	  mav.getModelMap().put("newAves", aves);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveAves", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newAves")Aves aves, BindingResult result, SessionStatus status) throws Exception
	 {
	  avesService.persist(aves);
	  status.setComplete();
	  return "redirect:/aves/all.html";
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception 
	 {
	  ModelAndView mav = new ModelAndView("/aves/editAves");
	  Aves aves = avesService.findById(id);
	  mav.addObject("editAves", aves);
	  return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editAves") Aves aves, BindingResult result, SessionStatus status) throws Exception
	 {
	  avesService.merge(aves);
	  status.setComplete();
	  return "redirect:/aves/all.html";
	 }
	 
	 /*
	  * REST SERVICES
	  */
	
	 @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
	 public @ResponseBody
	 List<Aves> getAves() throws Exception{
			return avesService.findAll();
	 }
	 
	 @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public @ResponseBody Aves getAves(@PathVariable Long id) throws Exception {
	 
			return avesService.findById(id);
	 
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public ModelAndView delete(@PathVariable Long id) throws Exception
	 {
	  ModelAndView mav = new ModelAndView("redirect:/aves/all.html");
	  avesService.remove(id);
	  return mav;
	 } 

	 
	 
	
	
}
