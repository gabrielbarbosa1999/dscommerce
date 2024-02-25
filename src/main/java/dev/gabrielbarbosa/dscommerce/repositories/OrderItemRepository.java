package dev.gabrielbarbosa.dscommerce.repositories;

import dev.gabrielbarbosa.dscommerce.entities.OrderItem;
import dev.gabrielbarbosa.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
