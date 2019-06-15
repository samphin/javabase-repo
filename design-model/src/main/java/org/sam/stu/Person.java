package org.sam.stu;

import java.util.Date;

/**
 * 建造者模式
 */
public class Person {

    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    private Double weight;

    public Person(PersonBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class PersonBuilder{
        private Integer id;

        private String name;

        private Integer age;

        private Date birthday;

        private Double weight;

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

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder(1001,"james").setAge(26).build();
        //System.out.println("person = " + );
    }
}
