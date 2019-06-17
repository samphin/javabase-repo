package org.sam.stu.mapper;

import org.sam.stu.entity.SecUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SecUserMapper extends Mapper<SecUser> {

    List<SecUser> selectAll();
}