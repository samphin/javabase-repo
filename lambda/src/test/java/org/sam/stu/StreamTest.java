package org.sam.stu;

import com.alibaba.fastjson.JSONObject;
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
        stream = Stream.of(1,2,3,4,5);
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
    public void list2ArrayTest(){
        Integer[] numArray = stream.toArray(Integer[]::new);
        for (int i = 0; i < numArray.length; i++) {
            System.out.println("numArray = " + numArray[i]);
        }
    }

    /**
     * 涉及拆箱、装箱操作的转换
     */
    @Test
    public void list2ArrayTest1(){
        int[] numArray = stream.mapToInt(n->n).toArray();
    }

    /**
     * 将Integer类型集合转换成String类型集合
     */
    @Test
    public void integerList2StringListTest(){
        List<Integer> intList = stream.collect(Collectors.toList());
        String[] stringArray = intList.stream().map(String::valueOf).toArray(String[]::new);
        Stream.of(stringArray).forEach(System.out::println);
    }
}
