package dev.gabrielbarbosa.dscommerce.repositories;

import dev.gabrielbarbosa.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
