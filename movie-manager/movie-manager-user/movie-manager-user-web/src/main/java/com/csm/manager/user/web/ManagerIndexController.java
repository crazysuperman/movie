package com.csm.manager.user.web;

import com.alibaba.fastjson.JSONObject;
import com.csm.common.fdfs.FastDFSFile;
import com.csm.common.fdfs.FastDFSUtils;
import com.csm.common.util.PropKit;
import com.csm.common.util.StrKit;
import com.csm.manager.user.pojo.po.User;
import com.csm.manager.user.pojo.vo.PageInfo;
import com.csm.manager.user.pojo.vo.QueryItem;
import com.csm.manager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GCC
 * @Github: https://github.com/littlechenchao
 * @Date: 2018/11/8 17:15
 * @Version 1.0
 */
@Controller
public class ManagerIndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String toIndex(){
        return "index";
    }


    @ResponseBody
    @RequestMapping("/users")
    public Object getUsersByPage(PageInfo pageInfo, QueryItem query){

        JSONObject obj = userService.getUsersByPage(pageInfo,query);
        return obj;
    }

    @ResponseBody
    @PostMapping("/updateuser")
    public int updateUser(User user){
        return userService.modifyUser(user);
    }

    @ResponseBody
    @PostMapping("/saveuser")
    public int saveUser(User user){
        return userService.saveUser(user);
    }

    @ResponseBody
    @PostMapping("/deleteuser")
    public int deleteUser(Integer id){
        return userService.removeUser(id);
    }

    @ResponseBody
    @PostMapping("/deletebatch")
    public int deleteBatch(@RequestParam("ids") List<String> ids){
        return userService.removeBatch(ids);
    }

    @ResponseBody
    @PostMapping("/uploadimagehead")
    public Map<String,Object> upload(MultipartFile file){
        Map<String ,Object> map = new HashMap<>();

        try {
            //1. 形成实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(),file.getOriginalFilename(),file.getSize());
            //2. 调用工具类进行文件上传
            // remotePath： group1/M00/00/00/xxx.jpg
            String remotePath = FastDFSUtils.uploadFile(fastDFSFile);
            //3. 形成返回的JSON
            if (StrKit.notBlank(remotePath)) {
                //不为空，成功
                String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
                String path = basePath + "/" + remotePath;
                map.put("msg", "success");
                map.put("src", path);
            } else {
                //失败
                map.put("msg", "failed");
                map.put("src", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
