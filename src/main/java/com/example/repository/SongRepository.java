package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Model.SongData;

public interface SongRepository extends MongoRepository<SongData, String> {
	
 public SongData findBySongname(String songname);
 public SongData deleteBySongname(String songname);
 public SongData findByAlbum(String album);

}
