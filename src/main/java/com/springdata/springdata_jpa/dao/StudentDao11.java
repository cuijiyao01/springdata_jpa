package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author i531869
 * @Date 2020/8/11 16:51
 * @Version 1.0
 */
public interface StudentDao11 extends JpaRepository<Student,Long>,
    JpaSpecificationExecutor<Student>,StudentRepository {

}
