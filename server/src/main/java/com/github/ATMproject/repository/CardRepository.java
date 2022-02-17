package com.github.ATMproject.repository;

import com.github.ATMproject.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByCardNumber(String cardNumber);
}
