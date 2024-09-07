package nz.co.stylesoftware.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;
import nz.co.stylesoftware.order.dto.OrderRequest;
import nz.co.stylesoftware.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order placed successfully";
	}
}
