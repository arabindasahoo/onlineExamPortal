package com.image.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "image_table")
public class Image {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "image_name")
	private String name;
	
	@Column(name = "image_type")
	private String type;
	
	@Column(name = "image_size")
	private byte[] picSize;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPicSize() {
		return picSize;
	}
	public void setPicSize(byte[] picSize) {
		this.picSize = picSize;
	}
	public Image(Long id, String name, String type, byte[] picSize) {
		super();
		Id = id;
		this.name = name;
		this.type = type;
		this.picSize = picSize;
	}
	public Image() {
		super();
	}
	
	

}
