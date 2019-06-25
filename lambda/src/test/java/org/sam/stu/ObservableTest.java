package org.sam.stu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.observable.Observable;
import org.junit.Before;
import org.junit.Test;
import org.sam.stu.po.Food;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK8 List新的操作方式
 *
 * @author samphin
 * @date 2019-6-3 23:52:48
 */
public class ObservableTest {

    private List<Food> foodList;

    @Before
    public void init() {
        //初始化集合元素
        foodList = Stream.of(
                new Food(1001, "banana", 20, 10D),
                new Food(1002, "tomato", 30, 22D),
                new Food(1003, "potato", 22, 40D),
                new Food(1004, "apple", 42, 20D),
                new Food(1005, "pear", 10, 5D),
                new Food(1006, "banana2", 21, 10D),
                new Food(1007, "banana3", 23, 10D)
        ).collect(Collectors.toList());
    }

    /**
     * 遍历List
     */
    @Test
    public void test1() {
        Observable<JSONArray> observable = Observable.zip(
                getFoodList(1001),
                getFoodList(1002),
                (food1,food2)->{
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(food1);
                    jsonArray.add(food2);
                    return jsonArray;
                }
        );
        System.out.println("blockingSingle = " + observable.blockingSingle().toJSONString());
        System.out.println("blockingFirst = " + observable.blockingFirst().toJSONString());
        System.out.println("blockingLast = " + observable.blockingLast().toJSONString());
        observable.blockingIterable().iterator().forEachRemaining(remain->{
            System.out.println("remain.toJSONString() = " + remain.toJSONString());
        });
    }

    public Observable<Food> getFoodList(int id){
        Food foodInfo = foodList.stream().filter(food->food.getId()==id).findFirst().get();
        return Observable.just(foodInfo);
    }
}
