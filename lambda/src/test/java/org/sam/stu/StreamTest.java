package org.sam.stu;

import com.alibaba.fastjson.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 集合处理Stream转换-->Collection、Array、String
 */
public class StreamTest {

    private Stream<Integer> stream;

    @Before
    public void initList() {
        //流式编程，向流中初始化值
        stream = Stream.of(1, 2, 3, 4, 5);
    }

    /**
     * 打印语句
     */
    @Test
    public void print() {
        stream.forEach(System.out::println);
    }

    /**
     * 将流转换成Integer数组
     */
    @Test
    public void test1() {
        Integer[] numArray = stream.toArray(Integer[]::new);
        Arrays.stream(numArray).forEach(System.out::println);
    }

    /**
     * 涉及拆箱、装箱操作的转换
     */
    @Test
    public void test2() {
        int[] numArray = stream.mapToInt(n -> n).toArray();
    }

    /**
     * 将Integer类型集合转换成String类型集合
     */
    @Test
    public void test3() {
        List<Integer> intList = stream.collect(Collectors.toList());
        String[] stringArray = intList.stream().map(String::valueOf).toArray(String[]::new);
        Stream.of(stringArray).forEach(System.out::println);
    }

    /**
     * 将Stream转换成Set
     */
    @Test
    public void test4() {
        Set<Integer> set = stream.collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    /**
     * 求和
     */
    @Test
    public void test5() {
        int sum = stream.mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);
    }

    /**
     * 求积
     */
    @Test
    public void test6() {
        int num = stream.mapToInt(Integer::intValue).reduce(1, (accumulate, n) -> accumulate * n);
        System.out.println("num = " + num);
    }

    /**
     * 对数组进行排序
     */
    @Test
    public void test7() {
        Integer[] arr = {20, 19, 40, 60, 10, 8};
        Arrays.sort(arr,Comparator.comparingInt(Integer::intValue));
        //arr = Arrays.stream(arr).sorted(Comparator.comparingInt(Integer::intValue).reversed()).toArray(Integer[]::new);
        System.out.println("arr = " + JSONArray.toJSONString(arr));
    }

    /**
     * 将list转换成set
     */
    @Test
    public void test8(){
        List<String> relation = new ArrayList<>(1);
        relation.add("abc");
        Set<String> set = relation.stream().collect(Collectors.toSet());
        System.out.println("set = " + JSONArray.toJSONString(set));
    }

}
