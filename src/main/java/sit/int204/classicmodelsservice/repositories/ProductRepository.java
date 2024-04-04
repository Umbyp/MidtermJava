package sit.int204.classicmodelsservice.repositories;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,String> {
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper,String productname);
    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productname, Sort sort);
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String productname, Pageable pageable);//ต้องใช้Page แทน List
    List<Product> findByProductNameContains(String productname);
    List<Product> findByProductLineStartingWith(String productLine);
    Product findFirstByOrderByPriceDesc(); //ตัวที่มีราคาสูงที่สุดมาใช้

    @Query("select  p from  Product  p where p.productLine like :category")
    List<Product> getProductsByCategory(String category);


}
