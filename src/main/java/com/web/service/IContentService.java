package com.web.service;

import java.util.List;

import org.web.entity.EContent;

import com.web.model.Content;



public interface IContentService {
	
	List<Content> getAllContent();
	public void save(EContent ec);
	public   EContent buscarPorTipo(String tipo);
	public   EContent findPorID(Long id);
	public void delete(Long id);

}
