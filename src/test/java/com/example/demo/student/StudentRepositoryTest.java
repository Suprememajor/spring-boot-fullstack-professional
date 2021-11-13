package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void selectExistsEmail() {
        //given
        String email = "janila@gmail.com";
        Student student = new Student(
                "Janila",
                email,
                Gender.FEMALE
        );
        underTest.save(student);
        //when
        Boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isTrue();
    }
}