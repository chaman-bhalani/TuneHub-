package com.example.sb.tunehub.services;

import java.util.List;

import com.example.sb.tunehub.entities.Playlist;

public interface playlistService {
	public String addPlaylist(Playlist playlist);
	
	public List<Playlist> fetchPlaylist();
}
