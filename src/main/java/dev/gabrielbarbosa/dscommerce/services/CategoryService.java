package dev.gabrielbarbosa.dscommerce.services;

import dev.gabrielbarbosa.dscommerce.dto.CategoryDTO;
import dev.gabrielbarbosa.dscommerce.dto.ProductDTO;
import dev.gabrielbarbosa.dscommerce.dto.ProductMinDTO;
import dev.gabrielbarbosa.dscommerce.entities.Category;
import dev.gabrielbarbosa.dscommerce.entities.Product;
import dev.gabrielbarbosa.dscommerce.repositories.CategoryRepository;
import dev.gabrielbarbosa.dscommerce.repositories.ProductRepository;
import dev.gabrielbarbosa.dscommerce.services.exceptions.DatabaseException;
import dev.gabrielbarbosa.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository productRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = productRepository.findAll();
        return categories.stream().map(CategoryDTO::new).toList();
    }


}
