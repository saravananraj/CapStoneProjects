package com.sara.ecommerce.repository;

import com.sara.ecommerce.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    public List<Product> getAllProducts();

    @Query("select p from Product p where p.id=?1")
    public Product getProductByIdByPosition(Long productId);

    @Query("select p from Product p where p.id=:productId")
    public Product getProductByIdByName(Long productId);

    List<Product> findProductByPriceBetween(Double price1, Double price2);

    List<Product>  findAllByOrderByPrice();
}
