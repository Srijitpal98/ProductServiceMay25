package com.ecommerce.productservicemay25.controllers;

import org.springframework.web.bind.annotation.*;

// Controller that's going to host REST/HTTP APIs
@RestController
@RequestMapping("/sample")
public class SampleController {

    //<domain-name>/sample/sayHello
    //API - function
//    @DeleteMapping("/sayHello")
//    public String sample1() {
//        return "Hello World!";
//    }

    //<domain-name>/sample/sayHello/Yogesh
    @GetMapping("/sayHello/{name}")
    public String sample(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("/sayHello2")
    public String sample2(@RequestParam("x") int x) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < x; i++) {
            sb.append("Hello World\n");
        }
        return sb.toString();
    }

    //<domain-name>/sample/sayHello2
//    @GetMapping("/sayHello2")
//    public String sample2() {
//        return "Hello World 2!";
//    }
}

// http://amazon.in/orders/create
// localhost:8080 : 192.68.1.7:8080
// ProductController - /products
// UserController - /users
// CategoryController - /categories

// HandlerMapping(maintained by framework)
// /sample -> SampleController
// /products -> ProductController
// /categories -> CategoryController
