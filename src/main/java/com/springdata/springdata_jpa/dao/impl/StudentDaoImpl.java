package com.springdata.springdata_jpa.dao.impl;

import com.springdata.springdata_jpa.dao.StudentRepository;
import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * @Author i531869
 * @Date 2020/8/11 16:52
 * @Version 1.0
 */
public class StudentDaoImpl implements StudentRepository {

  @Autowired
  private EntityManager em;

  @Override
  public Student findById(Integer id) {
    return em.find(Student.class,id);
  }
}
