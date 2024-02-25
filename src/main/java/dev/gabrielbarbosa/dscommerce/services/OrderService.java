package dev.gabrielbarbosa.dscommerce.services;

import dev.gabrielbarbosa.dscommerce.dto.OrderDTO;
import dev.gabrielbarbosa.dscommerce.entities.Order;
import dev.gabrielbarbosa.dscommerce.repositories.OrderRepository;
import dev.gabrielbarbosa.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final String ORDER_NOT_FOUND = "ORDER NÃO ENCONTRADO.";

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ORDER_NOT_FOUND));
        return new OrderDTO(order);
    }

}
