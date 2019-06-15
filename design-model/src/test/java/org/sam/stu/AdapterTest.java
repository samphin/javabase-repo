package org.sam.stu;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.sam.stu.adapter.SimpleApplication;
import org.sam.stu.adapter.SpringBoot;
import org.sam.stu.adapter.TroubleApplication;
import org.sam.stu.builder.Person;

import java.util.Date;

public class AdapterTest {

    @Test
    public void test(){
        SpringBoot simpleApplication = new SimpleApplication();

        simpleApplication.aopStarted();

        SpringBoot troubleApplication = new TroubleApplication();

        troubleApplication.aopStarted();
    }
}
