package com.springdata.springdata_jpa;

import com.springdata.springdata_jpa.dao.StudentDao5;
import com.springdata.springdata_jpa.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * @Author i531869
 * @Date 2020/8/11 15:39
 * @Version 1.0
 */
@SpringBootTest
public class JpaSpecificationExecutorTest {

  @Autowired
  StudentDao5 studentDao5;

  @Autowired
  JpaSpec jpaSpec;

  @Test
  void test() {
    Specification spec = new Specification() {
      @Override
      public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("name"), "悟饭");
      }
    };
    List<Student> list = studentDao5.findAll(spec);
    System.out.println(list);

    Specification specification = new Specification() {
      @Override
      public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder
            .and(criteriaBuilder.equal(root.get("age"), 23), criteriaBuilder.equal(root.get("name"), "古天乐"));
      }
    };
    Optional<Student> optional = studentDao5.findOne(specification);
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  @Test
  public void test2() {
    // Specification spec = new Specification() {
    //   @Override
    //   public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
    //     return criteriaBuilder.ge(root.get("age"), 23);
    //   }
    // };
    // Page<Student> students = studentDao5.findAll(spec, PageRequest.of(1, 3));
    // System.out.println("总页数:" + students.getTotalPages());
    // System.out.println("总数目:" + students.getTotalElements());
    // for (Student student : students.getContent()) {
    //   System.out.println(student);
    // }
    //
    // Specification spec2 = new Specification() {
    //   @Override
    //   public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
    //     return criteriaBuilder.and(criteriaBuilder.ge(root.get("id"), 9),
    //         criteriaBuilder.le(root.get("age"), 40));
    //   }
    // };
    // List<Student> students1 = studentDao5.findAll(spec2, Sort.by(Sort.Direction.DESC, "age"));
    // for (Student student : students1) {
    //   System.out.println(student);
    // }
    //
    Specification spec3 = new Specification() {
      @Override
      public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThan(root.get("age"),20);
      }
    };

    Page<Student> page = studentDao5.findAll(spec3,PageRequest.of(2,3,Sort.by(new Order(Sort.Direction.ASC,"id"))));
    System.out.println(page.getTotalElements());
    System.out.println(page.getTotalPages());
    for (Student student : page.getContent()) {
      System.out.println(student);
    }
    List<Student> s = jpaSpec.findAll(spec3);

    for (Student student : s) {
      System.out.println(student);
    }
  }
}
