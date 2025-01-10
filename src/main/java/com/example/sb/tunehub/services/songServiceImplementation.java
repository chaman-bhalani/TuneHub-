package com.example.sb.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb.tunehub.entities.Song;
import com.example.sb.tunehub.repositories.songRepository;

@Service
public class songServiceImplementation implements songService{
	
	@Autowired
	songRepository songrepo;
	
	@Override
	public String addSong(Song song) {
		songrepo.save(song);
		return "Songs is added";
	}

	@Override
	public boolean songExists(String name) {
		Song song=songrepo.findByName(name);
		if(song==null) {
			return false;
		}else {
			
			return true;
		}
	}

	@Override
	public List<Song> fetchAllSong() {

		List<Song> songlist=songrepo.findAll();
		return songlist;
	}

	@Override
	public String updateSong(Song song) {
		songrepo.save(song);
		return "update the songs";
		
	}

	
}
