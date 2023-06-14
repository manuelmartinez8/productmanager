package com.web.service;

import com.web.model.Product;
import com.web.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.web.entity.EProduct;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

public class ProductServiceTest {
    @Autowired
    private ProductRepository repository;

    @Test
    public void guardar () {
        EProduct ep= new EProduct();
    ep.setDescripcion("Cemento");
    ep.setCategoria("Construccion");
    ep.setStock(12);

        EProduct eProduct = new EProduct();
        System.out.println(repository.save(ep));
        String a =null;
        //eProduct=  repository.save(ep);
    assertNotNull(a);
    }

}
