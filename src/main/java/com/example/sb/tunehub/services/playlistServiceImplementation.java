package com.example.sb.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb.tunehub.entities.Playlist;
import com.example.sb.tunehub.repositories.playlistRepository;

@Service
public class playlistServiceImplementation implements playlistService{
	
	@Autowired
	playlistRepository playrepo;

	@Override
	public String addPlaylist(Playlist playlist) {
		playrepo.save(playlist);
		return "playlist added to database";
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		return playrepo.findAll();
	}
}
