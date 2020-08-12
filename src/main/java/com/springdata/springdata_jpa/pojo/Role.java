package com.springdata.springdata_jpa.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Author i531869
 * @Date 2020/8/11 17:29
 * @Version 1.0
 */
@Entity
@Table(name="t_role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roleid")
  private Integer roleid;

  @Column(name = "rolename")
  private String rolename;

  @OneToOne(mappedBy = "role")
  private Person person;

}
