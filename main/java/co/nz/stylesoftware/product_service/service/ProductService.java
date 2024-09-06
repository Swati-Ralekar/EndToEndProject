package co.nz.stylesoftware.product_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.nz.stylesoftware.product_service.dto.ProductRequest;
import co.nz.stylesoftware.product_service.dto.ProductResponse;
import co.nz.stylesoftware.product_service.model.Product;
import co.nz.stylesoftware.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;


@Service
//@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	Logger log = LoggerFactory.getLogger(ProductService.class);
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		productRepository.save(product);
		log.info("Product created: {}", product , " Successfully!");
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
	
	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll()
				.stream()
				.map(product -> 
            new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
				.toList();
	}
}
