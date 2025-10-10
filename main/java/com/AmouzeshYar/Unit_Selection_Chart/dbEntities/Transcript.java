package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import com.AmouzeshYar.Unit_Selection_Chart.projectEnumiration.TranscriptStatus;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TranscriptStatus transcriptStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
