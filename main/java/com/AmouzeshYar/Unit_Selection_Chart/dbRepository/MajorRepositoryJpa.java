package com.AmouzeshYar.Unit_Selection_Chart.dbRepository;

import com.AmouzeshYar.Unit_Selection_Chart.dbEntities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepositoryJpa extends JpaRepository<Major ,Long> {


}
