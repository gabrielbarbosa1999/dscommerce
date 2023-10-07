package dev.gabrielbarbosa.dscommerce.repositories;

import dev.gabrielbarbosa.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
