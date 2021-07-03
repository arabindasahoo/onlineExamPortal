package com.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.image.dao.ImageDaoImpl;
import com.image.model.Image;

@Controller
public class ImageController {
	
	@Autowired
	private ImageDaoImpl imageDaoImpl;

	@GetMapping(value = "/")
	public String getIndex()
	{
		return "index";
	}
}
