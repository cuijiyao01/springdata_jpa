package com.springdata.springdata_jpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Author i531869
 * @Date 2020/8/11 17:33
 * @Version 1.0
 */
@Entity
@Table(name="t_person")
@Getter
@Setter
@ToString(callSuper = true)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "personid")
  private Integer personid;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;

  @OneToOne
  @JoinColumn(name = "roleid")
  private Role role;
}
