package org.sam.stu.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sam.stu.UsersApplication;
import org.sam.stu.entity.User1000w;
import org.sam.stu.service.IUser1000wService;
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
public class User1000wTest {
	@Autowired
	private IUser1000wService user1000wService;
	
	@Test
	public void findUserForChen() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("firstName", "陈");
		long t1 = System.currentTimeMillis();
		System.out.println("开始查询："+t1);
		List<User1000w> users = user1000wService.queryAll();
		long t2 = System.currentTimeMillis();
		System.out.println("查询总耗时："+(t2-t1)+"，姓陈的用户共有"+users.size()+"条！");
	}
	
	/**
	 * 从redis中取出姓陈用户信息
	 */
	@Test
	public void getUserInfoFromRedis() {
		long t1 = System.currentTimeMillis();
		System.out.println("从Redis中开始查询："+t1);
		List<User1000w> users = user1000wService.queryAll();
		/*for (Object object : users) {
			User1000w user = (User1000w)object;
			System.out.println("用户姓名："+user.getFirstName()+user.getLastName());
		}*/
		long t2 = System.currentTimeMillis();
		System.out.println("查询总耗时："+(t2-t1)+"，姓陈的用户共有"+users.size()+"条！");
	}
	
}
