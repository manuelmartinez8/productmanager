package org.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.web.entity.EContent;


import com.web.model.Content;


@Component
public class ContentConverter {
	
	public List<Content> convertirContent(List<EContent> contenidos){
		List<Content> modelContent= new ArrayList<>();
		
		for(EContent ep: contenidos) {
			modelContent.add(new Content(ep));
		}	
		
		return modelContent;
	}
	
	
	public Content convertirUnProducto(EContent ec) {
		Content p = new Content(ec);
		return  p;
	}
	
}
