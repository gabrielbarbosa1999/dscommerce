package dev.gabrielbarbosa.dscommerce.controlers;

import dev.gabrielbarbosa.dscommerce.dto.OrderDTO;
import dev.gabrielbarbosa.dscommerce.dto.ProductDTO;
import dev.gabrielbarbosa.dscommerce.dto.ProductMinDTO;
import dev.gabrielbarbosa.dscommerce.services.OrderService;
import dev.gabrielbarbosa.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO order = service.findById(id);
        return ResponseEntity.ok(order);
    }

    @PreAuthorize("hasAnyRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO order = service.insert(orderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

}
