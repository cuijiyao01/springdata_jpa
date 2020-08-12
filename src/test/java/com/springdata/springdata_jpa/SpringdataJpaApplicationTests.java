package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.dao.StudentDao;
import com.springdata.springdata_jpa.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class SpringdataJpaApplicationTests {

  @Test
  void contextLoads() {
  }

  @Autowired
  private StudentDao studentDao;

  @Test
  void test1() {
    // Student student = new Student();
    // student.setName("stu1");
    // student.setAge(18);
    // student.setGender("male");
    // student.setBirth(new Date("1993-04-16"));
    List<Student> students = studentDao.findByName("stu1");
    for (Student student : students) {
      System.out.println(student);
    }
  }

	@Test
	void test2() {
		// Student student = new Student();
		// student.setName("stu1");
		// student.setAge(18);
		// student.setGender("male");
		// student.setBirth(new Date("1993-04-16"));
		List<Student> students = studentDao.findByAgeAndGender(19,"male");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	void test3() {
		// Student student = new Student();
		// student.setName("stu1");
		// student.setAge(18);
		// student.setGender("male");
		// student.setBirth(new Date("1993-04-16"));
		List<Student> students = studentDao.findByNameLike("stu%");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	//
	// @Test
	// void test4() {
	// 	// Student student = new Student();
	// 	// student.setName("stu1");
	// 	// student.setAge(18);
	// 	// student.setGender("male");
	// 	// student.setBirth(new Date("1993-04-16"));
	// 	List<Student> students = studentDao.findByAgeGreaterThanEquals(19);
	// 	for (Student student : students) {
	// 		System.out.println(student);
	// 	}
	// }

	@Test
	void test5() {
		// Student student = new Student();
		// student.setName("stu1");
		// student.setAge(18);
		// student.setGender("male");
		// student.setBirth(new Date("1993-04-16"));
		List<Student> students = studentDao.queryByBirth(new Date(1993,5,16));
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Test
	void test6() {
		// Student student = new Student();
		// student.setName("stu1");
		// student.setAge(18);
		// student.setGender("male");
		// student.setBirth(new Date("1993-04-16"));
		List<Student> students = studentDao.queryById(3l);
		for (Student student : students) {
			System.out.println(student);
		}
  }

	@Test
	@Transactional
	@Rollback(value = false)
	void test7() {
		studentDao.updateStudentById("zhangwuj",28,"male",2l);
	}
}
