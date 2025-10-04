package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@Data
@Builder
@Entity
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",  nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id", nullable = false)
    private Major major;
}
