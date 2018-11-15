package com.csm.manager.cinema.inter;

import com.alibaba.fastjson.JSONObject;
import com.csm.manager.cinema.pojo.dto.PageInfo;
import com.csm.manager.cinema.pojo.po.CinemaPO;
import org.springframework.web.multipart.MultipartFile;

public abstract interface CinemaInterface
{
    public abstract JSONObject selectCinema(PageInfo paramPageInfo);

    public abstract String deleteCinema(Integer paramInteger);

    public abstract String deleteALL(int[] paramArrayOfInt);

    public abstract String updateCinema(CinemaPO paramCinemaPO);

    public abstract String saveCinema(CinemaPO paramCinemaPO);

    public abstract String uploadImage(MultipartFile paramMultipartFile);
}
