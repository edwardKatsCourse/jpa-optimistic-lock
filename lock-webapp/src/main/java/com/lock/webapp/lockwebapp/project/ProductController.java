package com.lock.webapp.lockwebapp.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public void test(@RequestHeader("client_name") String clientName) {
        try {
            productService.test(clientName);

        } catch (Exception e) {
            System.out.println("client_name modification error: " + clientName);
        }
    }
}

