package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.dao.StudentDao3;
import com.springdata.springdata_jpa.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author i531869
 * @Date 2020/8/10 20:32
 * @Version 1.0
 */
@SpringBootTest
public class PagingAndSortingRepositoryTest {

  @Autowired
  StudentDao3 studentDao3;

  @Test
  void test1() {
    List<String> props = new ArrayList<>();
    props.add("age");
    props.add("account");

    Order order = new Order(Direction.DESC, "age");
    Order order2 = new Order(Direction.ASC, "id");
    // Order[] orders = (Order[]) new Order[]{order,order2};
    // List<Student> students = (List<Student>) studentDao3.findAll(Sort.by(Direction.ASC, props.toArray(new String[props.size()])));
    studentDao3.findAll(Sort.by(order, order2));
  }

  @Test
  void test2() {
    // Pageable pageable = PageRequest.of(0, 4);
    // studentDao3.findAll();
    Student student = new Student();
    student.setName("悟饭");
    student.setAge(14);
    student.setGender("male");

    Student student2 = new Student();
    student2.setName("特南克斯");
    student2.setAge(19);
    student2.setGender("male");

    Student student3 = new Student();
    student3.setName("布玛");
    student3.setAge(34);
    student3.setGender("female");

    Student student4 = new Student();
    student4.setName("琪琪");
    student4.setAge(35);
    student4.setGender("female");

    List<Student> students = new ArrayList<>();
    students.add(student);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    studentDao3.saveAll(students);
  }

  @Test
  void test3() {
    Pageable pageable = PageRequest.of(2, 3);
    Page<Student> page = studentDao3.findAll(pageable);
    System.out.println("所有学生数:" + page.getTotalElements());
    System.out.println("所有页数" + page.getTotalPages());
    for(Student s : page.getContent()){
      System.out.println(s);
    }
  }

  @Test
  void test4() {
    Pageable pageable = PageRequest.of(2, 3,Sort.by(Direction.DESC,"id"));
    Page<Student> page = studentDao3.findAll(pageable);
    System.out.println("所有学生数:" + page.getTotalElements());
    System.out.println("所有页数" + page.getTotalPages());
    for(Student s : page.getContent()){
      System.out.println(s);
    }
  }
}
