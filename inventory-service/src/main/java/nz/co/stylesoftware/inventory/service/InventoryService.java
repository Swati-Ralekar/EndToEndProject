package nz.co.stylesoftware.inventory.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nz.co.stylesoftware.inventory.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	public boolean isInStock(String skuCode, Integer quantity) {
		return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);

    }
		
	}
