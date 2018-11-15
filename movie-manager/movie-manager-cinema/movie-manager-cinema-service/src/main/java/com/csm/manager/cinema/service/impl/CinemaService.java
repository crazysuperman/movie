package com.csm.manager.cinema.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csm.common.fdfs.FastDFSFile;
import com.csm.common.fdfs.FastDFSUtils;
import com.csm.common.util.Prop;
import com.csm.common.util.PropKit;
import com.csm.manager.cinema.dao.CinemaMapper;
import com.csm.manager.cinema.inter.CinemaInterface;
import com.csm.manager.cinema.pojo.dto.PageInfo;
import com.csm.manager.cinema.pojo.po.CinemaPO;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CinemaService
        implements CinemaInterface
{
    @Autowired
    private CinemaMapper dao;

    public JSONObject selectCinema(PageInfo pageInfo)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            List<CinemaPO> poList = this.dao.selectCinema(pageInfo);
            Long count = this.dao.selectCount(pageInfo);
            jsonObject.put("total", count);
            jsonObject.put("list", poList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String deleteCinema(Integer cid)
    {
        try
        {
            this.dao.deleteCinema(cid);
            return "ok";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "fail";
    }

    public String deleteALL(int[] arr)
    {
        try
        {
            this.dao.deleteALL(arr);
            return "ok";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "fail";
    }

    public String updateCinema(CinemaPO cinemaPO)
    {
        try
        {
            this.dao.updateCinema(cinemaPO);
            return "ok";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "fail";
    }

    public String saveCinema(CinemaPO cinemaPO)
    {
        try
        {
            this.dao.saveCinema(cinemaPO);
            return "ok";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "fail";
    }

    public String uploadImage(MultipartFile file)
    {
        try
        {
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), Long.valueOf(file.getSize()));

            String remotePath = FastDFSUtils.uploadFile(fastDFSFile);

            String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
            return basePath + "/" + remotePath;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
