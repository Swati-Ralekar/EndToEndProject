package nz.co.stylesoftware.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nz.co.stylesoftware.order.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
