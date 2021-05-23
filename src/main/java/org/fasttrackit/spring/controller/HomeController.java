package org.fasttrackit.spring.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.fasttrackit.spring.dao.CategoriiDAO;
import org.fasttrackit.spring.model.Categorii;
import org.fasttrackit.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getFullName());
		return "user";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Magazin In Constructie</h3>Deschiderea in curand **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/lista-categorii1")
	public ModelAndView helloWorld1() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Magazin In Constructie</h3>Deschiderea in curand **********</div><br><br>";
		return new ModelAndView("categorii1", "message", message);
	}
	@RequestMapping(value="/lista-categorii")
	public ModelAndView listareLocatii() throws SQLException {
		ArrayList<Categorii>listCategorie = new ArrayList<Categorii>();
		ArrayList<Categorii>listaCategorii = new ArrayList<Categorii>();
		Categorii categorie = null;
		CategoriiDAO ldao = new CategoriiDAO();
		CategoriiDAO cdao = new CategoriiDAO();
		
		int nr = 1;
		 listaCategorii = ldao.getListaCategorii();
		
		for(Categorii numeCategorie :listaCategorii) {
			
		//categorie=ldao.getCategorieParinte(numeCategorie.getNumeCatParinte());
		categorie.setId(nr);
		listCategorie.add(categorie);
		nr++;
		                   }	
		ModelMap model = new ModelMap();
		model.addAttribute("nr", nr);
		model.addAttribute("categorie", listCategorie);
		return new ModelAndView("categorii", "model", model);
	}
	
	
}
