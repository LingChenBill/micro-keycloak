package com.lc.keycloak.controller;

import com.lc.keycloak.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * product controller.
 *
 * @author zyz.
 */
@RestController
public class ProductController {

    /**
     * 首页.
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "welcome to Keycloak index page!";
    }

    /**
     * 获取产品.
     *
     * @return
     */
    @GetMapping("/product")
    public Product getProduct() {
        Product product = new Product();
        product.setId("p-0001");
        product.setName("iphone");
        product.setPrice(new BigDecimal(5100.0));
        return product;
    }

    /**
     * 获取用户名.
     *
     * @return
     */
    @GetMapping("/user")
    public List<String> getUserNameList() {
        return Arrays.asList("lc-001", "lc-002", "lc-003");
    }
}
