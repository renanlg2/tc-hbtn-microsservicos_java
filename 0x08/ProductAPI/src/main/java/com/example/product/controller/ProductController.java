package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "API CRUD Products")
@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    @GetMapping(value = "/welcome")
    public String welcome(){
        return "BEM VINDO À PRODUCT REST API.";
    }

    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @GetMapping(value = "/allProducts")
    public List<Product> allProducts(){
        return productRepository.getAllProducts();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @GetMapping(value = "/findProductById/{id}")
    public Product findProductById(@PathVariable("id") Integer idProduct){
        return productRepository.getProductById(idProduct);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody Product product){
        productRepository.addProduct(product);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @ApiOperation(value = "Responsável por atualizar um produto.")
    @PutMapping(value = "/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productRepository.updateProduct(product);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @ApiOperation(value = "Responsável por remover um produto.")
    @DeleteMapping(value = "/removeProduct")
    public void removeProduct(Integer idProduct){

        Product product = productRepository.getProductById(idProduct);

        if (product != null)
            productRepository.removeProduct(product);
    }

}
