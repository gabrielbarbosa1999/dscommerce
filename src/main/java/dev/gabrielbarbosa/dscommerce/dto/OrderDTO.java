package dev.gabrielbarbosa.dscommerce.dto;

import dev.gabrielbarbosa.dscommerce.entities.Order;
import dev.gabrielbarbosa.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;

    private Instant moment;

    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    @NotEmpty(message = "DEVE TER AO MENOS UM ITEM.")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.client = new ClientDTO(order.getClient());
        this.payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        this.items = order.getItems().stream().map(OrderItemDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for(OrderItemDTO item: items) {
            sum += item.getSubTotal();
        }
        return sum;
    }

}
