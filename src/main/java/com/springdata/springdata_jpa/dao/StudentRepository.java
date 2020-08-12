package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;

/**
 * @Author i531869
 * @Date 2020/8/11 16:50
 * @Version 1.0
 */
public interface StudentRepository {
  Student findById(Integer id);
}
