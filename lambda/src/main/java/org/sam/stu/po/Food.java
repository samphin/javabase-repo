package org.sam.stu.po;

import lombok.Data;
import lombok.ToString;
import org.sam.stu.annotation.FoodAnnotation;

@Data
@ToString
public class Food {

    private int id;

    @FoodAnnotation(name = "食物名称", classType = Food.class, description = "食物描述")
    private String name;

    @FoodAnnotation(name = "食物重量", classType = Food.class, description = "食物重量")
    private double weight = 0D;

    @FoodAnnotation(name = "食物数量", classType = Food.class, description = "食物数量")
    private int count = 0;

    @FoodAnnotation(name = "食物颜色", classType = Food.class, description = "食物颜色")
    private String colour;

    @FoodAnnotation(name = "食物颜色描述", classType = Food.class, description = "食物颜色描述")
    private String colourDecription;

    public Food() {
    }

    public Food(int id, String name, int count, double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public Food(int id, String name, int count, double weight, String colour) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
        this.colour = colour;
    }

    public Food(int id, String name, int count, double weight, String colour,String colourDecription) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
        this.colour = colour;
        this.colourDecription = colourDecription;
    }
}
