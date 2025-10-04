package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import com.AmouzeshYar.Unit_Selection_Chart.projectEnumiration.CourseTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Min(value = 1, message = "Minimum credits 1")
    @Max(value = 3, message = "Maximum credits 3")
    @Column(nullable = false)
    private int unitCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseTypeEnum courseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prerequest_id")
    private Course prerequest;

    @OneToMany(mappedBy = "course")
    private List<Curriculum> curriculumList;

    @OneToMany(mappedBy = "course")
    private List<Transcript> transcriptList;

}
