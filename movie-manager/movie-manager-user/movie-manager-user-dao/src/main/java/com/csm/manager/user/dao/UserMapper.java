package com.csm.manager.user.dao;


import com.csm.manager.user.pojo.po.User;
import com.csm.manager.user.pojo.vo.PageInfo;
import com.csm.manager.user.pojo.vo.QueryItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 分页查询用户
     * @param pageInfo
     * @return
     */
    List<User> selectUsersByPage(@Param("pageInfo") PageInfo pageInfo, @Param("query") QueryItem query) throws Exception;

    /**
     * 分页查询用户数量
     * @return
     */
    Long countUsersByPage(@Param("query") QueryItem query) throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    void updateUser(User user) throws  Exception;

    /**
     * 新增用户
     * @param user
     * @throws Exception
     */
    void insertUser(User user) throws  Exception;

    /**
     * 删除单个用户
     * @param id
     * @throws Exception
     */
    void deleteUser(int id) throws Exception;

    /**
     * 批量删除用户
     * @param ids
     * @throws Exception
     */
    void deleteBatch(List<String> ids) throws Exception;
}
