package com.clinicaodonto.repository;

import com.clinicaodonto.model.DentistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<DentistModel, Integer> {
}
