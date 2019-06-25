package org.sam.stu;

import org.junit.Test;
import org.sam.stu.annotation.FoodAnnotation;
import org.sam.stu.po.Food;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 自定义注解解析
 */
public class AnnotationTest {
    @Test
    public void test(){
        Field[] fields = Food.class.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            FoodAnnotation fa = field.getAnnotation(FoodAnnotation.class);
            if(null!= fa){
                System.out.println("name = " + fa.name());
                System.out.println("classType = " + fa.classType());
                System.out.println("description = " + fa.description());
            }
        });
    }
}
