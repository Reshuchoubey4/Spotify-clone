package com.example.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "SongData")
public class SongData {
	@Id
	private String id;
	private String album;
	private String songname;
	private String singername;
	private String filename;
	
//	private MultipartFile file;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getSingername() {
		return singername;
	}
	public void setSingername(String singername) {
		this.singername = singername;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
//	public MultipartFile getFile() {
//		return file;
//	}
//	public void setFile(MultipartFile file) {
//		this.file = file;
//	}
	public SongData(String album, String singername,String songname, String filename) {
		super();
		this.album = album;
		this.singername = singername;
		this.filename = filename;
//		this.file = file;
		this.songname = songname;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	
	

}
