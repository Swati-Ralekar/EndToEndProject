package nz.co.stylesoftware.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import nz.co.stylesoftware.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
		return inventoryService.isInStock(skuCode, quantity);
	}
}
