package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students;

    @OneToMany(mappedBy = "major")
    private List<Curriculum> curriculums;
}
