package org.slevin.controller;

import org.slevin.common.Paises;
import org.slevin.common.Zonas;
import org.slevin.dao.PaisesDao;
import org.slevin.dao.ZonasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/country")
public class PaisesController {

	@Autowired
    PaisesDao countryService;

    @Autowired
    ZonasDao zonasService;
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllCountriesView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/country/showAllCountries");
	  List<Paises> country = countryService.findAll();
	  mav.addObject("countries", country);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newCountriesForm() throws Exception {
         ModelAndView mav = new ModelAndView("/country/newCountry");
         Paises country = new Paises();
         List<Zonas> zonas = zonasService.findAll();

         mav.getModelMap().put("newCountry", country);
         mav.getModelMap().put("zonas", zonas);
         return mav;
	 }

    @RequestMapping(value="/saveCountry", method=RequestMethod.POST)
    public String create(@ModelAttribute("newCountry")Paises country,@RequestParam(required = false) List<Long> zonaId , BindingResult result, SessionStatus status) throws Exception
    {
        if(zonaId != null){
            for(Long idZona : zonaId){
                Zonas zona = zonasService.findById(idZona);
                country.getZonas().add(zona);
                country.setCdZona(zona);
            }
        }

        countryService.merge(country);
        status.setComplete();
        return "redirect:/country/all.html";
    }

	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception
	 {
         ModelAndView mav = new ModelAndView("/country/editCountry");
         Paises country = countryService.findById(id);
         List<Zonas> zonas = new ArrayList<Zonas>(country.getZonas());
         mav.addObject("editCountry", country);
         mav.addObject("zonas", zonas);
         return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editCountry") Paises country, BindingResult result, SessionStatus status) throws Exception
	 {
         Paises countryTmp = countryService.findById(id);
         country.setZonas(countryTmp.getZonas());
         countryService.merge(country);
         status.setComplete();
         return "redirect:/country/all.html";
	 }

    @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
    public @ResponseBody
    List<Paises> getContries() throws Exception{
        return countryService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
    public @ResponseBody Paises getCuontry(@PathVariable Long id) throws Exception {

        return countryService.findById(id);

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
    public ModelAndView delete(@PathVariable Long id) throws Exception
    {
        ModelAndView mav = new ModelAndView("redirect:/country/all.html");
        countryService.remove(id);
        return mav;
    }

}
