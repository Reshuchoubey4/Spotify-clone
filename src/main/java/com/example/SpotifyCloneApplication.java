package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.SongData;

@SpringBootApplication
@RestController
@RequestMapping("/songs")
public class SpotifyCloneApplication {
	

	@GetMapping("/hellpo")
	public String songinput() {
//		SongData newsong = new SongData(sd.getSingername(), sd.getAlbum(), sd.getSongname(), sd.getFilename());
////		SongData x = songrepo.findBySongname("");
//		songrepo.save(newsong);
		return "ok";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpotifyCloneApplication.class, args);
	}

}
