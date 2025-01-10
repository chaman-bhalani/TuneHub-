package com.example.sb.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.tunehub.entities.Playlist;

public interface playlistRepository extends JpaRepository<Playlist, Integer> {

}
