package org.slevin.controller;

import java.util.List;

import org.slevin.common.Zonas;
import org.slevin.dao.ZonasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/zonas")
public class ZonasController {

	@Autowired
	ZonasDao zonasService;
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllZonasView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/zonas/showAllZonas");
	  List<Zonas> zonas = zonasService.findAll();
	  mav.addObject("zonas", zonas);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newZonasForm()
	 {
	  ModelAndView mav = new ModelAndView("/zonas/newZona");
	  Zonas zonas = new Zonas();
	  mav.getModelMap().put("newZona", zonas);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveZona", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newZona")Zonas zonas, BindingResult result, SessionStatus status) throws Exception
	 {
	  zonasService.persist(zonas);
	  status.setComplete();
	  return "redirect:/zonas/all.html";
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception 
	 {
	  ModelAndView mav = new ModelAndView("/zonas/editZona");
	  Zonas zonas = zonasService.findById(id);
	  mav.addObject("editZona", zonas);
	  return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editZona") Zonas zonas, BindingResult result, SessionStatus status) throws Exception
	 {
	  zonasService.merge(zonas);
	  status.setComplete();
	  return "redirect:/zonas/all.html";
	 }
	 
	 /*
	  * REST SERVICES
	  */
	
	 @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
	 public @ResponseBody
	 List<Zonas> getItems() throws Exception{
			return zonasService.findAll();
	 }
	 
	 @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public @ResponseBody Zonas getZonas(@PathVariable Long id) throws Exception {
	 
			return zonasService.findById(id);
	 
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public ModelAndView delete(@PathVariable Long id) throws Exception
	 {
	  ModelAndView mav = new ModelAndView("redirect:/zonas/all.html");
	  zonasService.remove(id);
	  return mav;
	 } 

	 
	 
	
	
}
