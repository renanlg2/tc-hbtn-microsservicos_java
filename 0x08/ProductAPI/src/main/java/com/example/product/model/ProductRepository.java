package com.example.product.model;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts(){
        return this.list;
    }

    public Product getProductById(Integer id){
        return this.list.stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product s){
        if (!this.list.contains(s)){
            this.list.add(s);
        }
    }

    public void updateProduct(Product s){
        if (this.list.contains(s)){
            this.list.set(this.list.indexOf(s), s);
        }
    }

    public void removeProduct(Product s){
        if (this.list.contains(s)){
            this.list.remove(s);
        }
    }

    public void addList(List<Product> listOfProducts) {
        for (Product product: listOfProducts) {
            if (!this.list.contains(product)){
                this.list.add(product);
            }
        }
    }

}
