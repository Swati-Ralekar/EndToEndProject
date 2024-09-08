package nz.co.stylesoftware.order.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nz.co.stylesoftware.order.client.InventoryClient;
import nz.co.stylesoftware.order.dto.OrderRequest;
import nz.co.stylesoftware.order.model.Order;
import nz.co.stylesoftware.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final InventoryClient inventoryClient;

	public void placeOrder(OrderRequest orderRequest) {
		// Map the OrderRequest to Order entity
		if(inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity())){
			Order order = new Order();
			order.setOrderNumber(orderRequest.orderNumber());
			order.setSkuCode(orderRequest.skuCode());
			order.setPrice(orderRequest.price());
			order.setQuantity(orderRequest.quantity());
			// Save the Order entity to OrderRepository
			orderRepository.save(order);
		}
		else {
			throw new RuntimeException("Product with sku Code "+ orderRequest.skuCode() + " is not in stock");
		}
	}
}
