package com.lc.keycloak.controller;

//import com.lc.keycloak.model.Product;

import com.lc.keycloak.service.ProductService;
import org.keycloak.common.util.KeycloakUriBuilder;
import org.keycloak.constants.ServiceUrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * product controller.
 *
 * @author zyz.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;

//    /**
//     * 首页.
//     *
//     * @return
//     */
//    @GetMapping("/")
//    public String index() {
//        return "welcome to Keycloak index page!";
//    }

//    /**
//     * 获取产品.
//     *
//     * @return
//     */
//    @GetMapping("/product")
//    public Product getProduct() {
//        Product product = new Product();
//        product.setId("p-0001");
//        product.setName("iphone");
//        product.setPrice(new BigDecimal(5100.0));
//        return product;
//    }

    /**
     * 获取用户名.
     *
     * @return
     */
    @GetMapping("/user")
    public List<String> getUserNameList() {
        return Arrays.asList("lc-001", "lc-002", "lc-003");
    }

    /**
     * products view method.
     *
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String handleCustomersRequest(Principal principal, Model model) {
//        model.addAttribute("products", productService.getProducts());
//        model.addAttribute("principal", principal);
//        String logoutUri = KeycloakUriBuilder.fromUri("http://localhost:8180/auth").path(ServiceUrlConstants.TOKEN_SERVICE_LOGOUT_PATH)
//                .queryParam("redirect_uri", "http://localhost:8080/products").build("quickstart").toString();
//        model.addAttribute("logout", logoutUri);
        return "products";
    }

    /**
     * logout method.
     *
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogoutt() throws ServletException {
        request.logout();
        return "landing";
    }

    /**
     * landing method.
     *
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing() throws ServletException {
        return "landing";
    }

}
