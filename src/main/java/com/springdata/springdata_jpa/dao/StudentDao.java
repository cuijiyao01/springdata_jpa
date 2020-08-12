package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.sql.Date;
import java.util.List;

/**
 * @Author i531869
 * @Date 2020/8/10 15:19
 * @Version 1.0
 */
public interface StudentDao extends Repository<Student, Long> {
  List<Student> findByName(String name);

  List<Student> findByAgeAndGender(Integer age, String gender);

  // List<Student> findByBirthGreaterThanEquals(String birth);

  List<Student> findByNameLike(String name);

  @Query("from Student where birth<?1")
  List<Student> queryByBirth(Date date);

  @Query(value = "select * from t_student where id = :id",nativeQuery = true)
  List<Student> queryById(Long id);

  @Query(value = "update t_student set name=:name,age=:age,gender=:gender where id=:id",nativeQuery = true)
  @Modifying
  void updateStudentById(String name,int age,String gender,Long id);
}
