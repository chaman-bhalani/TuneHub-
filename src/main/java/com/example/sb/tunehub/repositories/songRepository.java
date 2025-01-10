package com.example.sb.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.tunehub.entities.Song;

public interface songRepository extends JpaRepository<Song, Integer>{

	public Song findByName(String name);

}
