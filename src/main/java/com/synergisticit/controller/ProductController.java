package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.synergisticit.domain.Product;
import com.synergisticit.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestPart("product") Product product, @RequestPart("file") MultipartFile file) {
        return productService.updateProduct(product, file);
    }

    @GetMapping("/active")
    public List<Product> getAllActiveProducts(@RequestParam String category) {
        return productService.getAllActiveProducts(category);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam String ch) {
        return productService.searchProduct(ch);
    }

    @GetMapping("/active/pagination")
    public Page<Product> getAllActiveProductsPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String category) {
        return productService.getAllActiveProductPagination(pageNo, pageSize, category);
    }

    @GetMapping("/search/pagination")
    public Page<Product> searchProductPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String ch) {
        return productService.searchProductPagination(pageNo, pageSize, ch);
    }

    @GetMapping("/pagination")
    public Page<Product> getAllProductsPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return productService.getAllProductsPagination(pageNo, pageSize);
    }

    @GetMapping("/search/active/pagination")
    public Page<Product> searchActiveProductPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String category, @RequestParam String ch) {
        return productService.searchActiveProductPagination(pageNo, pageSize, category, ch);
    }
}
