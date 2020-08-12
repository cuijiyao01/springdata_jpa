package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.dao.StudentDao4;
import com.springdata.springdata_jpa.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author i531869
 * @Date 2020/8/11 15:23
 * @Version 1.0
 */
@SpringBootTest
public class JpaRepositoryTest2 {

  @Autowired
  StudentDao4 studentDao4;

  @Test
  void test(){
    List<Student> list = studentDao4.findAll();
    for (Student s : list) {
      System.out.println(s);
    }

    Student student = studentDao4.getOne(7l);
    System.out.println(student);
  }
}
