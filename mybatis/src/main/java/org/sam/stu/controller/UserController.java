package org.sam.stu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sam.stu.entity.SecUser;
import org.sam.stu.entity.User1000w;
import org.sam.stu.service.ISecUserService;
import org.sam.stu.service.IUser1000wService;
import org.sam.stu.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 *
 * @author samphin
 * @date 2019-6-17 23:04:30
 */
@Api(value = "用户Controller")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUser1000wService user1000wService;

    @Autowired
    private ISecUserService iSecUserService;

    /**
     * 查询列表
     *
     * @return
     */
    @ApiOperation(value = "查询普通用户列表", notes = "查询普通用户列表")
    @GetMapping(value = "/query-user")
    public ResponseResult queryList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SecUser> dataList = iSecUserService.queryAll();
        PageInfo<SecUser> pageInfo = new PageInfo<>(dataList);

        return new ResponseResult().success(pageInfo);
    }

    /**
     * 查询1000W用户信息
     *
     * @return
     */
    @ApiOperation(value = "1000w用户表", notes = "1000w用户表")
    @GetMapping(value = "/query-1000w-user")
    public ResponseResult query1000WUserList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<User1000w> user1000wList = user1000wService.queryAll();

        PageInfo<User1000w> pageInfo = new PageInfo<>(user1000wList);

        return new ResponseResult().success(pageInfo);
    }

    /**
     * 新增用户
     *
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping
    public ResponseResult addUser(@RequestBody User1000w user) {
        try {
            user1000wService.insert(user);
            return new ResponseResult().success();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult().failure();
        }
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable int id) {
        try {
            user1000wService.deleteByPrimaryKey(id);
            return new ResponseResult().success();
        } catch (Exception e) {
            return new ResponseResult().failure();
        }
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping
    public ResponseResult update(@RequestBody @Valid User1000w user) {
        try {
            user1000wService.updateByPrimaryKeySelective(user);
            return new ResponseResult().success();
        } catch (Exception e) {
            return new ResponseResult().failure();
        }
    }
}
