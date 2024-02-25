package dev.gabrielbarbosa.dscommerce.services;

import dev.gabrielbarbosa.dscommerce.dto.CategoryDTO;
import dev.gabrielbarbosa.dscommerce.entities.Category;
import dev.gabrielbarbosa.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
