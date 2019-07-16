package org.sam.stu;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.sam.stu.po.Food;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK8 List新的操作方式
 *
 * @author samphin
 * @date 2019-6-3 23:52:48
 */
public class ListNewUsageTest {

    private List<Food> foodList;

    private List<Food> foodList1;

    private List<Food> foodList2;

    private List<List<Food>> collectFoodList;

    @Before
    public void init() {
        //初始化集合元素
        foodList = Stream.of(
                new Food(1001, "banana", 20, 10D,"yellow"),
                new Food(1002, "tomato", 30, 22D,"yellow"),
                new Food(1003, "potato", 22, 40D,"yellow"),
                new Food(1004, "apple", 42, 20D,"red"),
                new Food(1005, "pear", 10, 5D,"yellowLight"),
                new Food(1006, "banana2", 21, 10D,"yellow"),
                new Food(1007, "banana3", 23, 10D,"yellow")
        ).collect(Collectors.toList());

        foodList1 = Stream.of(
                new Food(1008, "lemon", 60, 30D)
        ).collect(Collectors.toList());

        foodList2 = Stream.of(new Food(1009, "pitaya", 33, 18D)
        ).collect(Collectors.toList());

        collectFoodList = Stream.of(foodList, foodList1, foodList2).collect(Collectors.toList());
    }

    /**
     * 遍历List
     */
    @Test
    public void test1() {
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        list.forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 过滤List，输出集合大于等于30的元素
     */
    @Test
    public void test2() {
        Stream.of(30, 20, 10, 29, 35).filter(num -> num >= 30).forEach(num -> System.out.println(num));
    }

    /**
     * 对集合进行倒序操作，方法一
     */
    @Test
    public void test3() {
        List<Integer> list = Stream.of(30, 20, 10, 29, 35).collect(Collectors.toList());
        list.sort((a, b) -> b - a);
        list.forEach(System.out::println);
    }

    /**
     * 对集合进行倒序操作，方法二
     */
    @Test
    public void test4() {
        List<Integer> list = Stream.of(30, 20, 10, 29, 35).collect(Collectors.toList());
        //先正序，再反转集合
        list.sort(Comparator.comparingInt(Integer::intValue).reversed());
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
    public void test5() {
        int number = Stream.of(30, 20, 10, 29, 35).reduce(0, (sum, y) -> sum + y);
        System.out.println("number = " + number);
    }


    /**
     * 累乘
     */
    @Test
    public void test6() {
        int number = Stream.of(2, 2, 2, 2, 2).reduce(1, (multiply, y) -> multiply * y);
        System.out.println("number = " + number);
    }

    /**
     * 筛选出水果重量超过20的元素
     */
    @Test
    public void test7() {
        foodList.stream().filter(food -> food.getWeight() >= 20D).forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * 根据weight倒序集合信息（方法一）
     */
    @Test
    public void test8() {
        foodList.stream().sorted((f1, f2) -> (int) (f2.getWeight() - f1.getWeight())).forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * 根据weight倒序集合信息（方法二）
     */
    @Test
    public void test8_1() {
        foodList.stream().sorted(Comparator.comparingDouble(Food::getWeight).reversed()).forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * 根据weight倒序集合信息（方法三）
     */
    @Test
    public void test8_2() {
        foodList.sort((f1,f2)->(int)(f2.getWeight()-f1.getWeight()));
        foodList.forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * 根据weight倒序集合信息（方法四）
     */
    @Test
    public void test8_3() {
        foodList.sort(Comparator.comparingDouble(Food::getWeight).reversed());
        foodList.forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }


    /**
     * 打印集合信息
     */
    @Test
    public void test9() {
        foodList.stream().forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * jdk 8 流式编程 ，让你代码更优雅
     */
    @Test
    public void test10() {
        //jdk8以前写法
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        //打印
        for (Integer num : numList) {
            System.out.println("num = " + num);
        }

        //jdk8之后优雅写法
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    /**
     * flatMap
     */
    @Test
    public void test11() {
        collectFoodList.stream().flatMap(foodList -> foodList.stream()).collect(Collectors.toList()).forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * anyMatch：在判断条件里，只有有一个元素存在名字为banana的，则返回true，否则false，适用判断集合是否包含某些内容；
     */
    @Test
    public void test12() {
        boolean isExist = foodList.stream().anyMatch(food -> food.getName().equals("banana"));
        System.out.println("isExist = " + isExist);
    }

    /**
     * allMatch：在判断条件里，必须所有元素都包含banana的，才返回true；
     */
    @Test
    public void test13() {
        boolean isExist = foodList.stream().allMatch(food -> food.getName().equals("banana"));
        System.out.println("isExist = " + isExist);
    }

    /**
     * noneMatch：与allMatch作用相反，不包含这些内容
     */
    @Test
    public void test14() {
        boolean isExist = foodList.stream().noneMatch(food -> food.getName().equals("banana"));
        System.out.println("isExist = " + isExist);
    }

    /**
     * 集合聚合操作，针对Double类型字段
     */
    @Test
    public void test15() {
        DoubleSummaryStatistics ds = foodList.stream().mapToDouble(food -> food.getWeight()).summaryStatistics();
        //聚合总记录数
        double count = ds.getCount();
        System.out.println("count = " + count);
        //最重的水果
        double max = ds.getMax();
        System.out.println("max = " + max);
        //最轻的水果
        double min = ds.getMin();
        System.out.println("min = " + min);
        //水果平均值
        double avg = ds.getAverage();
        System.out.println("avg = " + avg);
        //水果总重量
        double sum = ds.getSum();
        System.out.println("sum = " + sum);
        System.out.println("ds = " + ds.toString());
    }


    /**
     * 将实体集合-->转换成部分字段组合的对象然后进行聚合操作
     * Optional
     */
    @Test
    public void test16() {
        Optional<Food> maxFoodOptional = foodList.stream().max(Comparator.comparingInt(Food::getCount));
        maxFoodOptional.ifPresent(food -> System.out.println("数量最多的食物 = " + food.getName() + "，" + food.getCount()));

        Optional<Food> minFoodOptional = foodList.stream().min(Comparator.comparingDouble(Food::getWeight));
        minFoodOptional.ifPresent(food -> System.out.println("重量最小的食物 = " + food.getName() + "，" + food.getWeight()));
        //直接求食物中数量最多的最大值
        OptionalInt maxCountFood = foodList.stream().mapToInt(Food::getCount).max();
        System.out.println("食物中数量最大值 = " + maxCountFood.getAsInt());

        //所有食物平均重量
        OptionalDouble od = foodList.stream().mapToDouble(Food::getWeight).average();
        System.out.println("所有食物平均重量 = " + od.getAsDouble());

        //求所有水果总数量
        int sumCount = foodList.stream().mapToInt(Food::getCount).sum();
        System.out.println("所有水果总量 = " + sumCount);
    }

    /**
     * 模糊匹配食物信息
     */
    @Test
    public void test17() {
        String keyword = "ba";
        foodList.stream().filter(food -> food.getName().contains(keyword)).forEach(food -> System.out.println("food = " + JSONObject.toJSONString(food)));
    }

    /**
     * 根据重量对食物进行分组
     */
    @Test
    public void test18() {
        Map<Double, List<Food>> foodGroup = foodList.stream().collect(Collectors.groupingBy(food -> food.getWeight()));
        System.out.println("weight:FoodGroup = " + JSONObject.toJSONString(foodGroup));
    }

    /**
     * 将id,name抽取出来生成为map对象
     */
    @Test
    public void test19() {
        Map<Integer, String> foodNameMap = foodList.stream()
                .collect(Collectors.toMap(Food::getId, Food::getName));
        System.out.println("id:name = " + foodNameMap);
    }

    /**
     * 将id,name抽取出来生成为map对象(等同于test19，这种方式适用于非JavaBean，例如：JSONObject,Map对象等，通过get取值)
     */
    @Test
    public void test19_1() {
        Map<Integer, String> foodNameMap = foodList.stream()
            .collect(Collectors.toMap(food->food.getId(),food->food.getName()));
        System.out.println("id:name = " + foodNameMap);
    }

    /**
     * 将列表数据按照cvs样式打印出来
     */
    @Test
    public void test20() {
        String result = foodList.stream().map(Food::getName).reduce((s, s1) -> s + "," + s1).get();
        System.out.println("result = " + result);
    }

    /**
     * 将list转换成map集合，针对自定义字段key：字段value
     */
    @Test
    public void test21() {
        Map<Integer, String> foodMap = foodList.stream().collect(Collectors.toMap(Food::getId, Food::getName));
        System.out.println("foodMap = " + foodMap);
    }

    /**
     * 针对test21中如果key有重复则抛异常，解决方案用重载的第三个参数解决
     * <p>
     * // 使用旧的值，本例子中结果打印：{shanghai=3, shenzhen=1, beijing=2}
     * (f, s) -> f
     * // 使用新的值替换旧的值，打印：{shanghai=3, shenzhen=1, beijing=4}
     * (f, s) -> s
     * // 对新值和旧值进行处理，比如返回新值与旧值的和：{shanghai=3, shenzhen=1, beijing=6}
     * (f, s) -> f + s
     */
    @Test
    public void test22() {
        Map<Integer, String> foodMap = foodList.stream().collect(Collectors.toMap(Food::getId, Food::getName, (f, s) -> f + s));
        System.out.println("foodMap = " + foodMap);
    }

    /**
     * mapping 根据重量对食物进行分组，并对食物名称用逗号隔开
     * mapping 方法用于对Stream中元素的某个具体属性做进一步的映射处理，一般是和其他方法一起组合使用
     * 按照水果重量分组，将组内食物名称用set集合装载，并显示
     * <p>
     * 显示结果：{5.0=[pear], 20.0=[apple], 40.0=[potato], 10.0=[banana, banana2, banana3], 22.0=[tomato]}
     */
    @Test
    public void test23() {
        Map<Double, Set<String>> foodNameMap = foodList.stream().collect(Collectors.groupingBy(Food::getWeight, Collectors.mapping(Food::getName, Collectors.toSet())));
        System.out.println("weight:FoodGroup = " + foodNameMap);
    }

    /**
     * 取出匹配的第一个元素，直接返回
     */
    @Test
    public void test24() {
        Food foodInfo = foodList.stream().filter(food -> food.getId() == 1001).findFirst().orElse(null);
        System.out.println("foodInfo = " + JSONObject.toJSONString(foodInfo));
    }

    /**
     * 取出所有匹配关键字的数据集
     */
    @Test
    public void test25() {
        Food foodInfo = foodList.stream().filter(food -> food.getName().contains("ba")).findAny().orElse(null);
        System.out.println("foodInfo = " + JSONObject.toJSONString(foodInfo));
    }

    /**
     * 把查询出来的数据进行修改
     */
    @Test
    public void test26() {
        foodList.stream().filter(food -> food.getId() == 1001).findFirst().ifPresent(food -> {
            food.setName("香蕉巴拉");
            System.out.println("foodInfo = " + JSONObject.toJSONString(food));
        });
    }

    /**
     * 从foodList抽取所有水果名称并装成一个新集合
     */
    @Test
    public void test27() {
        List<String> foodNameList = foodList.stream().map(Food::getName).collect(Collectors.toList());
        foodNameList.stream().forEach(System.out::println);
    }

    /**
     * 根据颜色分组
     */
    @Test
    public void test28(){
        Map<String, List<Food>> colourGroupMap = foodList.stream().collect(Collectors.groupingBy(Food::getColour));
        System.out.println("colourGroupMap = " + JSONObject.toJSONString(colourGroupMap));
    }
}
