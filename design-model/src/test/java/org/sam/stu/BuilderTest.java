package org.sam.stu;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.sam.stu.builder.Person;

import java.util.Date;

public class BuilderTest {

    @Test
    public void test(){
        /**
         * 创建对象
         */
        Person person = new Person.PersonBuilder(1001,"samphin").setAge(26).setBirthday(new Date()).setWeight(70D).build();

        System.out.println("person = " + JSONObject.toJSONString(person));
    }
}
