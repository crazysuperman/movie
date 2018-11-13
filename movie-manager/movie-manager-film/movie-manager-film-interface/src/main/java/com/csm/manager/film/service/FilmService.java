package com.csm.manager.film.service;

import com.alibaba.fastjson.JSONObject;
import com.csm.manager.film.pojo.po.FilmPo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface FilmService {
    /**
     * 查询所有影片信息
     * @return
     */
    public List<FilmPo> findAllFilm();

    /**
     * 分页查询影片信息
     * @param json
     * @return
     */
    JSONObject findByPageFilm(JSONObject json);

    /**
     * 编辑影片信息
     * @param json
     * @return
     */
    void modifyFilm(JSONObject json);

    /**
     * 添加影片信息
     * @param json
     */
    void addFilm(JSONObject json);

    /**
     * 删除商品
     * @param json
     */
    void removeFilm(JSONObject json);

    /**
     * 上传图片并返回map链接
     * @param file
     */
    Map<String, Object> uploadPoster(MultipartFile file);
}
