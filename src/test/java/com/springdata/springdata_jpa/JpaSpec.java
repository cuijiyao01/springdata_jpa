package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author i531869
 * @Date 2020/8/11 16:42
 * @Version 1.0
 */
public interface JpaSpec extends JpaSpecificationExecutor<Student>, JpaRepository<Student,Long> {
}
