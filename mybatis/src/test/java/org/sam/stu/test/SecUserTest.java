package org.sam.stu.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.sam.stu.UsersApplication;
import org.sam.stu.entity.SecUser;
import org.sam.stu.service.ISecUserService;
import org.sam.stu.util.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户测试用例
 * @author samphin
 */
@SpringBootTest(classes= UsersApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SecUserTest {
	@Autowired
	private ISecUserService userService;
	
	//最大并发数
	private final int MAX_NUM = 1;
	
	//实例化一个并发测试对象
	private CountDownLatch cdl = new CountDownLatch(MAX_NUM); 

	//通过线程池来创建线程
	ExecutorService es = Executors.newFixedThreadPool(MAX_NUM);
	
	//并发压力测试
	@Test
	public void findUserInfo() {
		for(int i = 0; i < MAX_NUM; i++){
			Thread newThread = new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println("大家好，我是新来的线程！");
					}
			});
			
			Thread queryUserThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						newThread.join();
						cdl.await();
						String userId = "3ce7d3cb-b248-438a-82df-4f6e7e4828ea";

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			//es.submit(newThread);
			es.submit(queryUserThread);
			cdl.countDown();
		}
		try {
			Thread.currentThread();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUserInfoToRedis() {
		String userId = "3ce7d3cb-b248-438a-82df-4f6e7e4828ea";
		List<SecUser> users = userService.queryAll();
		//取出当前用户的目录信息
		for (SecUser user : users) {
			System.out.println("用户ID："+user.getUserId()+"，用户名称："+user.getUserName());
		}
	}
	
	
}
