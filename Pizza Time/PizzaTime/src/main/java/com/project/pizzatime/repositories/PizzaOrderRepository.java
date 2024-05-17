package com.project.pizzatime.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.pizzatime.models.PizzaOrder;
@Repository
public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long> {

	Optional<PizzaOrder> findByUserId(Long idUser);
	@Query("SELECT p FROM PizzaOrder p WHERE p.user.id = :idUser AND p.status = true")
    List<PizzaOrder> findByUserIdAndStatus(@Param("idUser") Long idUser);
	
	@Query("SELECT p FROM PizzaOrder p WHERE p.user.id = :idUser AND (p.status = false Or p.status is null)")
	Optional<PizzaOrder>  findActiveOrder(@Param("idUser") Long idUser);
	
	 @Query("SELECT p FROM PizzaOrder p WHERE (p.user.id = :idUser AND p.favorite = true) ORDER BY id LIMIT 1")
	    Optional<PizzaOrder> findFavoriteOrder(@Param("idUser") Long idUser);
	
	 void deletePizzaOrderByStatus(boolean status);
	

}
