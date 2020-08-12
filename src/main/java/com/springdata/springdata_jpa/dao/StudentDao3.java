package com.springdata.springdata_jpa.dao;

import com.springdata.springdata_jpa.pojo.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author i531869
 * @Date 2020/8/10 20:31
 * @Version 1.0
 */
public interface StudentDao3 extends PagingAndSortingRepository<Student,Long> {
}
