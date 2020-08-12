package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.dao.StudentDao2;
import com.springdata.springdata_jpa.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author i531869
 * @Date 2020/8/10 19:55
 * @Version 1.0
 */
@SpringBootTest
public class CrudRepositoryTest {
  @Autowired
  StudentDao2 studentDao2;

  @Test
  void test1() {
    Student student = new Student();
    student.setName("刘德华");
    student.setAge(48);
    student.setGender("male");

    Student student1 = studentDao2.save(student);
    System.out.println(student1);
  }

  @Test
  void test2() {
    Student student = new Student();
    student.setName("古天乐");
    student.setAge(48);
    student.setGender("male");

    Student student2 = new Student();
    student2.setName("林志玲");
    student2.setAge(44);
    student2.setGender("female");

    List<Student> students = new ArrayList<>();
    students.add(student);
    students.add(student2);

    System.out.println(studentDao2.saveAll(students));

  }

  @Test
  void test3() {
    // Optional<Student> student = studentDao2.findById(6l);
    // System.out.println(studentDao2.findAll());

    System.out.println(studentDao2.findAllById(Arrays.asList(1l, 2l)));
  }

  @Test
  void test4() {
    // Student student = new Student();
    // student.setName("古天乐");
    // student.setAge(48);
    // student.setGender("male");
    // student.setId(6l);
    // studentDao2.delete(student);

    // studentDao2.deleteById(4l);
    studentDao2.deleteAll();
    // System.out.println(studentDao2.findAllById(Arrays.asList(1l, 2l)));
  }

  @Test
  void test5() {
    Optional<Student> optional = studentDao2.findById(9l);
    if (optional.isPresent()) {
      Student student = optional.get();
      student.setName("路飞");
      student.setAge(23);
      studentDao2.save(student);
    }

    // System.out.println(studentDao2.findAllById(Arrays.asList(1l, 2l)));
  }

  @Test
  @Transactional
  @Rollback(false)
  void test6() {
    Optional<Student> optional = studentDao2.findById(10l);
    if (optional.isPresent()) {
      Student student = optional.get();
      student.setName("卡卡罗特");
      student.setAge(32);
    }

    // System.out.println(studentDao2.findAllById(Arrays.asList(1l, 2l)));
  }
}
