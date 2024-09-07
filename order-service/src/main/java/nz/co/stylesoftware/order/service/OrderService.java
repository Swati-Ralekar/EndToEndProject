package nz.co.stylesoftware.order.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nz.co.stylesoftware.order.dto.OrderRequest;
import nz.co.stylesoftware.order.model.Order;
import nz.co.stylesoftware.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		// Map the OrderRequest to Order entity
		Order order = new Order();
		order.setOrderNumber(orderRequest.orderNumber());
		order.setSkuCode(orderRequest.skuCode());
		order.setPrice(orderRequest.price());
		order.setQuantity(orderRequest.quantity());
		// Save the Order entity to OrderRepository
		orderRepository.save(order);
	}
}
