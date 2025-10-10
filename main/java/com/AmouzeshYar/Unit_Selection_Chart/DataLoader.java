package com.AmouzeshYar.Unit_Selection_Chart;

import com.AmouzeshYar.Unit_Selection_Chart.dbEntities.*;
import com.AmouzeshYar.Unit_Selection_Chart.dbRepository.*;
import com.AmouzeshYar.Unit_Selection_Chart.projectEnumiration.CourseTypeEnum;
import com.AmouzeshYar.Unit_Selection_Chart.projectEnumiration.TranscriptStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements  CommandLineRunner {

    @Autowired
    private final StudentRepositoryJpa studentRepositoryJpa;

    @Autowired
    private final TranscriptRepositoryJpa transcriptRepositoryJpa;

    @Autowired
    private final CourseRepositoryJpa courseRepositoryJpa;

    @Autowired
    private final CurriculumRepositoryJpa curriculumRepositoryJpa;

    @Autowired
    private final MajorRepositoryJpa majorRepositoryJpa;

    public DataLoader(StudentRepositoryJpa studentRepositoryJpa,
                      TranscriptRepositoryJpa transcriptRepositoryJpa,
                      CourseRepositoryJpa courseRepositoryJpa,
                      CurriculumRepositoryJpa curriculumRepositoryJpa,
                      MajorRepositoryJpa majorRepositoryJpa) {
        this.transcriptRepositoryJpa = transcriptRepositoryJpa;
        this.courseRepositoryJpa = courseRepositoryJpa;
        this.curriculumRepositoryJpa = curriculumRepositoryJpa;
        this.majorRepositoryJpa = majorRepositoryJpa;
        this.studentRepositoryJpa = studentRepositoryJpa;
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // create Entity instance :

        Major  major = new Major();
        major.setName("مهندسی کامپیوتر");
        majorRepositoryJpa.save(major);


        Student s1=new Student();
        s1.setMajor(major);
        s1.setFullName("مهدی نوجهانی");
        s1.setStudentNumber("40019541054018");
        studentRepositoryJpa.save(s1);


        Course course1 = new Course();
        course1.setName("مبانی برنامه نویسی");
        course1.setPrerequest(null);
        course1.setCourseType(CourseTypeEnum.SPECIALIZED);
        course1.setUnitCode(3);
        courseRepositoryJpa.save(course1);


        Transcript  transcript = new Transcript();
        transcript.setStudent(s1);
        transcript.setGrade(12.24d);
        transcript.setTranscriptStatus(TranscriptStatus.PASSED);
        transcript.setCourse(course1);
        transcriptRepositoryJpa.save(transcript);


        Curriculum  curriculum1 = new Curriculum();
        curriculum1.setCourse(course1);
        curriculum1.setMajor(major);
        curriculum1.setSemester(1);
        curriculumRepositoryJpa.save(curriculum1);
    }
}
