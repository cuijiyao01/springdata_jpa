package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author i531869
 * @Date 2020/8/11 13:46
 * @Version 1.0
 */
public interface StudentDao4 extends JpaRepository<Student,Long> {
}
