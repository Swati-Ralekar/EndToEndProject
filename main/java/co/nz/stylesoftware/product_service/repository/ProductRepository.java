package co.nz.stylesoftware.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.nz.stylesoftware.product_service.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
