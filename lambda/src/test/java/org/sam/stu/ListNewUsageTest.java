package org.sam.stu;

import org.junit.Test;
import org.sam.stu.po.Food;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK8 List新的操作方式
 *
 * @author samphin
 * @date 2019-6-3 23:52:48
 */
public class ListNewUsageTest {

    /**
     * 遍历List
     */
    @Test
    public void foreachListTest() {
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        list.forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 过滤List，输出集合大于等于30的元素
     */
    @Test
    public void filterListContentTest() {
        Stream.of(30, 20, 10, 29, 35).filter(num -> num >= 30).forEach(num -> System.out.println(num));
    }

    /**
     * 对集合进行倒序操作，方法一
     */
    @Test
    public void sortListTest() {
        List<Integer> list = Stream.of(30, 20, 10, 29, 35).collect(Collectors.toList());
        list.sort((a, b) -> b - a);
        list.forEach(num -> System.out.println(num));
    }

    /**
     * 对集合进行倒序操作，方法二
     */
    @Test
    public void sortListTest2() {
        List<Integer> list = Stream.of(30, 20, 10, 29, 35).collect(Collectors.toList());
        Comparator<Integer> comparing = Comparator.comparing((Integer num) -> num);
        //先正序，再反转集合
        list.sort(Comparator.comparing((Integer num) -> num).reversed());
        list.forEach(num -> System.out.println(num));
    }

    /**
     * 对集合中元素进行累加求和
     * 例子：如何通过reduce操作对Stream中的数字求和，
     * 以0作为起点（这里的0指的不是坐标而是数字0，求乘积以1为
     * 起点），一个空Stream的求和结果，
     * 每一步都将Stream中的元素累加至sum,
     * 遍历Stream中的所有元素，sum的值就是所有元素的和。
     */
    @Test
    public void reduceListTest() {
        int number = Stream.of(30, 20, 10, 29, 35).reduce(0, (sum, y) -> sum + y);
        System.out.println("number = " + number);
    }


    /**
     * 累乘
     */
    @Test
    public void reduceListTest2() {
        int number = Stream.of(2,2,2,2,2).reduce(1, (multiply, y) -> multiply * y);
        System.out.println("number = " + number);
    }


    @Test
    public void maxOrMinTest(){
        Food banana = new Food(1001,"banana",100);
        Food tomato = new Food(1002,"tomato",88);
        Food apple = new Food(1003,"apple",66);
        Food pear = new Food(1004,"pear",120);

        List<Food> foodList = Stream.of(banana,tomato,apple,pear).collect(Collectors.toList());

        Optional<Food> maxFoodOptional = foodList.stream().max(Comparator.comparingInt(Food::getCount));
        Optional<Food> minFoodOptional = foodList.stream().min(Comparator.comparingInt(Food::getId));
        if(maxFoodOptional.isPresent()){
            Food food = maxFoodOptional.get();
            System.out.println("数量最多的食物 = " + food.getName()+"，"+food.getCount());
        }

        if(minFoodOptional.isPresent()){
            Food food = minFoodOptional.get();
            System.out.println("编号最小的食物 = " + food.getName()+"，"+food.getCount());
        }
    }
}
