package com.mylab.wul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mylab.wul.domain.Base;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long> {
	List<Base> findByName(String name);
}
