package org.sam.stu;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.sam.stu.po.Food;
import org.sam.stu.service.FoodCallable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * Unit test for simple App.
 */
public class CallableTest
{
    @Test
    public void test(){

        try {
            Callable<List<Food>> foodCallable = new FoodCallable();
            Optional optional = Optional.ofNullable(foodCallable.call());
            System.out.println(JSONArray.toJSONString(optional.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
