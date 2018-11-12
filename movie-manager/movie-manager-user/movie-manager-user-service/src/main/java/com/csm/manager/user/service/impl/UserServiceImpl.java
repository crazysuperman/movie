package com.csm.manager.user.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.csm.common.util.StrKit;
import com.csm.manager.user.dao.UserMapper;
import com.csm.manager.user.pojo.po.User;
import com.csm.manager.user.pojo.vo.PageInfo;
import com.csm.manager.user.pojo.vo.QueryItem;
import com.csm.manager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    @Transactional(readOnly = true)
    public JSONObject getUsersByPage(PageInfo pageInfo, QueryItem query) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("list",userDao.selectUsersByPage(pageInfo,query));
            jsonObject.put("total",getCountUsersByPage(query));
        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    @Transactional(readOnly = true)
    public int getCountUsersByPage(QueryItem query) {
        int count = 0;
        try {
            count = userDao.countUsersByPage(query).intValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int modifyUser(User user) {
        int flg = 0 ;
        try {
            userDao.updateUser(user);
            flg = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flg;
    }

    @Override
    public int saveUser(User user) {
        if(StrKit.isBlank(user.getUpicture())){
            user.setUpicture("http://106.12.215.54/group1/M00/00/00/rBAABFvlazmAaiboAAAJkR_J_Xo253.jpg");
        }
        int flg = 0 ;
        try {
            userDao.insertUser(user);
            flg = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flg;
    }

    @Override
    public int removeUser(int id) {
        int flg = 0 ;
        try {
            userDao.deleteUser(id);
            flg = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flg;
    }

    @Override
    public int removeBatch(List<String> ids) {
        int flg = 0 ;
        System.out.println(ids);
        try {
            userDao.deleteBatch(ids);
            flg = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flg;
    }
}
