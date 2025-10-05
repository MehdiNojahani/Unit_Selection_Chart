package com.AmouzeshYar.Unit_Selection_Chart.dbRepository;

import com.AmouzeshYar.Unit_Selection_Chart.dbEntities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {

}
