package org.sam.stu.builder;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * 建造者模式，如果一个字段属性值特别多，生成构造函数成为一个头疼的事情，建造者模式帮我们解决这种问题
 * @author samphin
 * @date 2019-6-15 16:28:40
 */
public class Person {

    //required parameter
    private Integer id;

    private String name;

    //optional parameter
    private Integer age;

    private Date birthday;

    private Double weight;

    public Person(PersonBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.birthday = builder.birthday;
        this.weight = builder.weight;
    }

    /** 一定要定义当前对象属生的get方法，否则创建的对象没法用，无意义 **/

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Double getWeight() {
        return weight;
    }

    /**
     * 通过静态内部类实现属性赋值
     */
    public static class PersonBuilder{
        private Integer id;

        private String name;

        private Integer age;

        private Date birthday;

        private Double weight;

        /**
         * 必填参数初始化
         * @param id
         * @param name
         */
        public PersonBuilder(Integer id,String name){
            this.id = id;
            this.name = name;
        }

        public PersonBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public PersonBuilder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
