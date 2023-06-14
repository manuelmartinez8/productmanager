package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.converter.ContentConverter;
import org.web.entity.EContent;

import com.web.model.Content;
import com.web.repository.ContenRepository;

@Service
public class ContenServiceImpl implements IContentService {
	
	@Autowired
	private ContenRepository repository;
	private ContentConverter converter = new ContentConverter();
	
	@Transactional
	@Override
	public List<Content> getAllContent() {
		List<Content> lp = new ArrayList<Content>();
		try {
			//falta el converter
			lp=converter.convertirContent(repository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lp;
	}

	@Override
	public void save(EContent ec) {
		repository.save(ec);

	}

	@Override
	public EContent buscarPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EContent findPorID(Long id) {
		EContent ec=null;
		 try {
			 System.out.println("EL VALOR DE ID ES" + id);
			 ec = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ec;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

}
