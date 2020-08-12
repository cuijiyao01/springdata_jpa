package com.springdata.springdata_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author i531869
 * @Date 2020/8/11 13:47
 * @Version 1.0
 */
@SpringBootTest
public class JpaRepositoryTest {

  @Test
  public void test() {
    // ObjectTool<String> tool = new ObjectTool<>();
    // tool.setObj(new String("ObjectTool"));
    // System.out.println("对象是:" + tool.getObj());
    //
    // ObjectTool<Integer> tool2 = new ObjectTool<>();
    // tool2.setObj(10);
    // System.out.println("对象是:" + tool2.getObj());

    show(12);
    show("hello world");

    SubClass<String> subClass = new SubClass();
    subClass.setObj("小白");
    System.out.println(subClass.getName());

    List<String> list = new ArrayList<>();
    list.add("卡卡罗特");
    list.add("贝吉特");
    list.add("西路");
    show2(list);
    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);

    List<Double> list3 = new ArrayList<>();
    list3.add(1.2);
    list3.add(2.3);
    list3.add(3.4);
    show3(list2);
    show3(list3);

  }

  public <T> void show(T t) {
    System.out.println(t);
  }

  public void show2(List<?> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public void show3(List<? extends Number> list) {
    System.out.println(list);
  }

  public void show4(List<? super Number> list) {
    System.out.println(list);
  }
}

class ObjectTool<T> {
  private T obj;

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }
}

class SubClass<T> extends ObjectTool<T> {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
