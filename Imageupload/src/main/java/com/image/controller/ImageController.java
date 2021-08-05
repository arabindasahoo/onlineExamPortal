package com.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.image.dao.ImageDaoImpl;

@Controller
public class ImageController {
	
	@Autowired
	private ImageDaoImpl imageDaoImpl;

	@GetMapping(value = "/")
	public String getIndex()
	{
		return "index";
	}
	@PostMapping(value = "/")
	public String saveImage()
	{
		return "index";
	}
	@PostMapping(value = "/")
	public String getImage()
	{
		return "index";
	}
	
}
