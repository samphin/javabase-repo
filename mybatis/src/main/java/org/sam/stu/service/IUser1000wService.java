package org.sam.stu.service;

import java.util.List;
import java.util.Map;

import org.sam.stu.entity.User1000w;

public interface IUser1000wService {

	int deleteByPrimaryKey(Integer id);

    int insert(User1000w record);

    int insertSelective(User1000w record);

    User1000w queryByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User1000w record);

    int updateByPrimaryKey(User1000w record);
    
    List<User1000w> queryAll();
}
