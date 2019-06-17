package org.sam.stu.service.impl;

import org.sam.stu.entity.SecUser;
import org.sam.stu.mapper.SecUserMapper;
import org.sam.stu.service.ISecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecUserServiceImpl implements ISecUserService {

    @Autowired
    private SecUserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SecUser record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(SecUser record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public SecUser queryByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SecUser record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecUser record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SecUser> queryAll() {
        return userMapper.selectAll();
    }

}
