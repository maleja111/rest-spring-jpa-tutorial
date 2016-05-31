package org.slevin.controller;

import org.slevin.common.*;
import org.slevin.dao.AvesDao;
import org.slevin.dao.AvesPaisDao;
import org.slevin.dao.PaisesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/avespais")
public class AvesPaisController {

	@Autowired
    PaisesDao paisService;
	
	@Autowired
    AvesPaisDao avesPaisService;

    @Autowired
    AvesDao avesService;
	
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllAvesPaisView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/avespais/showAllAvesPais");
	  List<AvesPais> avespais = avesPaisService.findAll();
	  mav.addObject("avespais", avespais);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newAvesPaiForm() throws Exception
	 {
	  ModelAndView mav = new ModelAndView("/avespais/newAvesPais");
	  AvesPais avesPais = new AvesPais();
	  List<Paises> paises = paisService.findAll();
	  List<Aves> aves = avesService.findAll();

	  mav.getModelMap().put("newAvesPais", avesPais);
	  mav.getModelMap().put("paises", paises);
	  mav.getModelMap().put("aves", aves);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveAvesPais", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newAvesPais")AvesPais avesPais,@RequestParam(required = false) List<Long> aveId ,List<Long> paisId , BindingResult result, SessionStatus status) throws Exception
	 {
		 if(aveId != null){
	     for(Long idAve : aveId){
	    	 Aves aves = avesService.findById(idAve);
	    	 avesPais.getAves().add(aves);
	     }
		 }

         if(paisId != null){
             for(Long idPais : paisId){
                 Paises paises = paisService.findById(idPais);
                 avesPais.getPaises().add(paises);
             }
         }

	  avesPaisService.merge(avesPais);
	  status.setComplete();
	  return "redirect:/avepais/all.html";
	 }
	 
	
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception 
	 {
	  ModelAndView mav = new ModelAndView("/avespais/editAvesPais");
	  AvesPais avesPais = avesPaisService.findById(id);
	  List<Aves> aves = new ArrayList<Aves>(avesPais.getAves());
	  List<Paises> paises = new ArrayList<Paises>(avesPais.getPaises());
	  mav.addObject("editAvesPais", avesPais);
	  mav.addObject("aves", aves);
	  mav.addObject("paises", paises);
	  return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editAvesPais") AvesPais avesPais, BindingResult result, SessionStatus status) throws Exception
	 {
	  AvesPais avepaisTmp = avesPaisService.findById(id);
	  avesPais.setAves(avepaisTmp.getAves());
      avesPais.setPaises(avepaisTmp.getPaises());
	  avesPaisService.merge(avesPais);
	  status.setComplete();
	  return "redirect:/avespais/all.html";
	 }
	 
	 /*
	  * REST SERVICES
	  */
	
	 @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
	 public @ResponseBody
	 List<AvesPais> getavesPais() throws Exception{
			return avesPaisService.findAll();
	 }
	 
	 @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public @ResponseBody AvesPais getAvePais(@PathVariable Long id) throws Exception {
	 
			return avesPaisService.findById(id);
	 
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public ModelAndView delete(@PathVariable Long id) throws Exception
	 {
	  ModelAndView mav = new ModelAndView("redirect:/avespais/all.html");
	  avesPaisService.remove(id);
	  return mav;
	 } 

	 
	
	
}
