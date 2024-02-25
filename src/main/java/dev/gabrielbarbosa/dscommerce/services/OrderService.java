package dev.gabrielbarbosa.dscommerce.services;

import dev.gabrielbarbosa.dscommerce.dto.OrderDTO;
import dev.gabrielbarbosa.dscommerce.entities.*;
import dev.gabrielbarbosa.dscommerce.repositories.OrderItemRepository;
import dev.gabrielbarbosa.dscommerce.repositories.OrderRepository;
import dev.gabrielbarbosa.dscommerce.repositories.ProductRepository;
import dev.gabrielbarbosa.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    private final String ORDER_NOT_FOUND = "ORDER NÃO ENCONTRADO.";

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ORDER_NOT_FOUND));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);

        List<OrderItem> orderItems = orderDTO.getItems().stream().map(item -> {
            Product product = productRepository.getReferenceById(item.getProductId());
            return new OrderItem(order, product, item.getQuantity(), product.getPrice());
        }).toList();
        order.getItems().addAll(orderItems);
        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }
}
