package org.sam.stu.mapper;

import org.sam.stu.entity.User1000w;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface User1000wMapper extends Mapper<User1000w> {

    List<User1000w> selectAll();
}