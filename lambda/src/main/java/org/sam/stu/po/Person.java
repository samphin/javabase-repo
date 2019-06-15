package org.sam.stu.po;

public class Person {

    //required parameter
    private int id;

    private String name;

    //optional parameter
    private int count;

    private double weight;

    //通过建造者传递参数
    public Person(PersonBuilder foodBuilder) {
        this.id = foodBuilder.id;
        this.name = foodBuilder.name;
        this.count = foodBuilder.count;
        this.weight = foodBuilder.weight;
    }

    public static class PersonBuilder {

        private int id;

        public String name;

        public int count;

        public double weight;

        public PersonBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }


        public PersonBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public PersonBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
