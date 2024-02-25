package dev.gabrielbarbosa.dscommerce.repositories;

import dev.gabrielbarbosa.dscommerce.entities.Category;
import dev.gabrielbarbosa.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
