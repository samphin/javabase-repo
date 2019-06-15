package org.sam.stu.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Food {

    private int id;

    private String name;

    private double weight = 0D;

    private int count = 0;

    private String colour;

    public Food(int id, String name, int count,double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }
}
