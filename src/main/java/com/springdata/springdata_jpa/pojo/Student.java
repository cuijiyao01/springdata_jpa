package com.springdata.springdata_jpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author i531869
 * @Date 2020/8/10 15:11
 * @Version 1.0
 */
@Entity
@Table(name="t_student")
@Getter
@Setter
@ToString(callSuper = true)
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="age")
  private Integer age;

  @Column(name = "birth")
  private Date birth;

  @Column(name = "gender")
  private String gender;

  @Column(name = "account")
  private String account;

  @Column(name = "plainpassword")
  private String plainPassword;
}
