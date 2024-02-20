package dev.gabrielbarbosa.dscommerce.repositories;

import dev.gabrielbarbosa.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT product FROM Product product " +
            "WHERE UPPER(product.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> findByName(String name, Pageable pageable);

}
