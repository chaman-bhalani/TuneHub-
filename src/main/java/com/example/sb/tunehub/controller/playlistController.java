package com.example.sb.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sb.tunehub.entities.Playlist;
import com.example.sb.tunehub.entities.Song;
import com.example.sb.tunehub.services.playlistService;
import com.example.sb.tunehub.services.songService;

@Controller
public class playlistController {
	
	@Autowired
	playlistService playserv;
	
	@Autowired
	songService songserv;
	
	@GetMapping("/map-createplaylist")
	public String createPlayList(Model model) {
//		fetching the songs using song service
		List<Song> songlist=songserv.fetchAllSong();
//		adding the song in the model
		model.addAttribute("songlist", songlist);
//		sending createplaylist
		return "createPlaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		playserv.addPlaylist(playlist);
		List<Song> songlist=playlist.getSong();
		for(Song song: songlist) {
			song.getPlaylist().add(playlist);
			songserv.updateSong(song);
		}
		return "adminHome";
	}
	
	@GetMapping("/map-viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> plylist=playserv.fetchPlaylist();
		model.addAttribute("plylist", plylist);
		return "viewPlaylist";
	}
}
