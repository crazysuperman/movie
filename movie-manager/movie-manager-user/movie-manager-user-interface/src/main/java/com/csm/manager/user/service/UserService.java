package com.csm.manager.user.service;

import com.alibaba.fastjson.JSONObject;
import com.csm.manager.user.pojo.po.User;
import com.csm.manager.user.pojo.vo.PageInfo;
import com.csm.manager.user.pojo.vo.QueryItem;

import java.util.List;


public interface UserService {

    //获取user列表
    JSONObject getUsersByPage(PageInfo pageInfo, QueryItem query);

    //获取user数量
    int getCountUsersByPage(QueryItem query);

    //修改用户
    int modifyUser(User user);

    //新增用户
    int saveUser(User user);

    //删除单个用户
    int removeUser(int id);

    //批量删除用户
    int removeBatch(List<String> ids);
}
