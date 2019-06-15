package org.sam.stu.service;

import org.sam.stu.po.Food;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 带有返回值线程
 */
public class FoodCallable implements Callable {

    private List<Food> foodList = null;

    public FoodCallable(){
        //初始化集合元素
        foodList = Stream.of(
                new Food(1001, "banana", 20, 10D),
                new Food(1002, "tomato", 30, 22D),
                new Food(1003, "potato", 22, 40D),
                new Food(1004, "apple", 42, 20D),
                new Food(1005, "pear", 10, 5D),
                new Food(1006, "banana2", 20, 10D),
                new Food(1007, "banana3", 20, 10D)
        ).collect(Collectors.toList());
    }

    @Override
    public Object call() throws Exception {
        return foodList;
    }

}
