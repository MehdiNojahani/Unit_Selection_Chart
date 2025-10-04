package com.AmouzeshYar.Unit_Selection_Chart.dbEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student>  students = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Major major)) return false;
        return Objects.equals(id, major.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
