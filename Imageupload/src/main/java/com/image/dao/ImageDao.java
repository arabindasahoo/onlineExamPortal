package com.image.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.image.model.Image;

public interface ImageDao extends JpaRepository<Image, Long> {

}
