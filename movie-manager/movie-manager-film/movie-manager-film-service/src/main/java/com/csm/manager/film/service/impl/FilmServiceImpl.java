package com.csm.manager.film.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csm.common.fdfs.FastDFSFile;
import com.csm.common.fdfs.FastDFSUtils;
import com.csm.common.util.PropKit;
import com.csm.common.util.StrKit;
import com.csm.manager.film.dao.FilmMapper;
import com.csm.manager.film.pojo.po.FilmPo;
import com.csm.manager.film.service.FilmService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmMapper pm;

    @Override
    public List<FilmPo> findAllFilm() {
        return pm.selectAllFilm();
    }
    @Override
    public JSONObject findByPageFilm(JSONObject json) {
        json.put("offSet",((int)json.get("page")-1)*(int)json.get("pageSize"));
        //封装商品总数
        json.put("totalCount",pm.selectTotalFilm(json));
        //分页查询商品
        List<FilmPo> list = pm.selectByPageFilm(json);
        //封装查询出的分页商品
        json.put("list",list);
        return json;
    }
    @Override
    public void modifyFilm(JSONObject json) {
        pm.updateFilm(json);
    }
    @Override
    public void addFilm(JSONObject json) {
        pm.insertFilm(json);
    }
    @Override
    public void removeFilm(JSONObject json) {
        pm.deleteFilm(json);
    }

    @Override
    public Map<String, Object> uploadPoster(MultipartFile file) {
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            //1. 形成实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //2. 调用工具类进行文件上传
            // remotePath： group1/M00/00/00/xxx.jpg
            String remotePath = FastDFSUtils.uploadFile(fastDFSFile);
            //3. 形成返回的JSON
            if (StrKit.notBlank(remotePath)) {
                //不为空，成功
                String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
                String path = basePath + "/" + remotePath;
                data.put("src", path);
            } else {
                //失败
                String path = "http://118.31.40.47/group1/M00/00/00/rBCY4FvlSX-AVQTJABefzVLMyYo086.jpg";
                data.put("src", path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
