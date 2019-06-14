package org.sam.stu.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Food {

    private int id;

    private String name;

    private double weight;

    private int count;

    private String colour;

    public Food(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
