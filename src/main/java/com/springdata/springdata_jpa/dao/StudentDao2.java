package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author i531869
 * @Date 2020/8/10 19:54
 * @Version 1.0
 */
public interface StudentDao2 extends CrudRepository<Student,Long> {
}
