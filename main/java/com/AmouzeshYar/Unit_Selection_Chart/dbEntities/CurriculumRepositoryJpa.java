package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepositoryJpa extends JpaRepository<Curriculum,Long> {
}
