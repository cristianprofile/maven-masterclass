package com.mylab.wul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mylab.wul.domain.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {
}
