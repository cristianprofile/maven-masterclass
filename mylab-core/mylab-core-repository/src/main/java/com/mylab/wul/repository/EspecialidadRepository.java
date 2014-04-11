package com.mylab.wul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mylab.wul.domain.Especialidad;

@Repository
public interface EspecialidadRepository extends
		JpaRepository<Especialidad, Long> {
}
