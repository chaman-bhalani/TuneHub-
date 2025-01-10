package com.example.sb.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sb.tunehub.entities.Song;
import com.example.sb.tunehub.services.songService;

@Controller
public class songController {

	@Autowired
	songService songserv;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		
		boolean status=songserv.songExists(song.getName());
		
		if(status==false) {
			
			songserv.addSong(song);
			return "adminHome";
		}else {
			return "adminHomes";		
			}
	}
	@GetMapping("/map-viewsong")
	public String viewSong(Model model) {
		List<Song> songlist=songserv.fetchAllSong();
		model.addAttribute("songlist", songlist);
		return "displaySongs";
	}
	
	@GetMapping("/viewsong")
	public String viewCustomerSong(Model model) {
		boolean primeCustomerStatus=true;
		if(primeCustomerStatus==true) {
			List<Song> songlist=songserv.fetchAllSong();
			model.addAttribute("songlist", songlist);
			
			return "displaySongs";
		}else {
			return "makepayment";
		}
	}
}
