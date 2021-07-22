package com.spring.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.model.Alien;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	/*@RequestMapping("add")
	public String add(HttpServletRequest req) {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int num3=i+j;
		HttpSession session=req.getSession();
		session.setAttribute("n3",num3);
		return "result.jsp";
	}*/
	/*@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,HttpSession session) {
		
		int num3=i+j;
		
		session.setAttribute("n3",num3);
		return "result.jsp";
	}*/
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap mv) {
		
		//mv.setViewName("result");
		int num3=i+j;
		
		mv.addAttribute("n3",num3);
		return "result";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien a,Model m) {
		
		m.addAttribute("alien", a);
		return "result";
	}
	
	@ModelAttribute
	public String addModel(Alien a,Model m) {
		String aname=a.getAname();
		m.addAttribute("name", aname);
		return("result");
	}

}
	
