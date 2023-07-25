package com.app.cards.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.cards.entity.Cards;
@Repository
public interface CardRepository extends CrudRepository<Cards, Long>{

	List<Cards> findByCustomerId(int customerId);
}
