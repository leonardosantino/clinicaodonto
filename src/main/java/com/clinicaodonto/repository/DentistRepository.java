package com.clinicaodonto.repository;

import com.clinicaodonto.model.DentistModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<DentistModel, Integer> {
}
