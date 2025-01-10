package com.example.sb.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sb.tunehub.entities.Song;
import com.example.sb.tunehub.entities.Users;
import com.example.sb.tunehub.services.UsersService;
import com.example.sb.tunehub.services.songService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersService userv;
	
	@Autowired
	songService songserv;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) 
	{
		boolean userstatus=userv.emailExists(user.getEmail());
			if(userstatus==false) {
				userv.addUser(user);
				return "login";
			}
			else 
			{
				return "login";
			}
//		return "home";
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		
//		invoking validateUser() in service
		if(userv.validateUser(email, password)==true) {
			
			session.setAttribute("email", email);
			
//			checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin")) {
				return "adminHome";
			}else {
				
				return "customerHome";
			}
		}
		else {
			return "login";
//			return "register";
		}
	}
	
	@GetMapping("/exploresong")
	public String exploreSong(HttpSession session, Model model) {
		
		String email=(String) session.getAttribute("email");
		
		Users user=userv.getUser(email);
		
		boolean userStatus=user.isPremium();
		
		if(userStatus==true) {
			List<Song> songlist=songserv.fetchAllSong();
			model.addAttribute("songlist", songlist);
			
			return "displaySongs";
		}else {
			return "payment";
		}
	}
}
