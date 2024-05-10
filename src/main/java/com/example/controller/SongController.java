package com.example.controller;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Model.SongData;
import com.example.repository.SongRepository;

@RestController
@RequestMapping("/song")
public class SongController {

	@Autowired
	SongRepository songrepo;
	
	@GetMapping("/hellonew")
	public String hellonew() {
		return "hellonewadmin";
	}
	
	@PostMapping("/createsong")
	public SongData songinput(@RequestBody SongData sd) throws Exception {
		SongData newsong = new SongData(sd.getSingername(), sd.getAlbum(), sd.getSongname(), sd.getFilename());
	
		return songrepo.save(newsong);
	}
	@GetMapping("/readsong")
	public SongData song(@RequestParam("songname") String songname) {
		SongData song=songrepo.findBySongname(songname);
		SongData s = songrepo.findByAlbum(songname);
		return song;
		
	}
	@PutMapping("/updatesong")
	public String updateUser(@RequestParam("id") String id ,@RequestParam("songname") String songname) {
		System.out.println("ok");
		SongData sd = songrepo.findById(id).get();
		sd.setSongname(songname);
		songrepo.save(sd);
	        return "update-user";
	    }
	@DeleteMapping("deletesong")
	public String delete(@RequestParam ("songname")String songname) {
		songrepo.deleteBySongname(songname);
		return "deleted";
	}
	@PostMapping("/upload") 
	  public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file )throws Exception {

	    String fileName = file.getOriginalFilename();
	    try {
	      file.transferTo( new File("C:\\Users\\Admin\\Documents\\" + fileName));
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	    return ResponseEntity.ok("File uploaded successfully.");
	  }

	}

	


