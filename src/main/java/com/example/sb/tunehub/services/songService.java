package com.example.sb.tunehub.services;

import java.util.List;

import com.example.sb.tunehub.entities.Song;

public interface songService {
	public String addSong(Song song);
	
	public boolean songExists(String name);
	
	public List<Song> fetchAllSong();
	
	public String updateSong(Song song);
}
