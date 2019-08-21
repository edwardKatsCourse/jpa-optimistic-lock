package com.lock.webapp.lockwebapp.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void test(String clientName) {
        long entryTime = System.nanoTime();
        System.out.println(entryTime + " client:  " + clientName);
        Product product = productRepository.getOne(1L);
        if (product.isUpdated()) {
            System.out.println("Product was already updated by " + product.getValue());
            return;
        }
        product.setValue(clientName);
        product.setUpdated(true);
        productRepository.save(product);

        System.out.printf("client_name updated entity: %s\n", clientName);

    }
}
