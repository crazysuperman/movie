package com.csm.manager.film.dao;

import com.alibaba.fastjson.JSONObject;
import com.csm.manager.film.pojo.po.FilmPo;
import java.util.List;

public interface FilmMapper {
    /**
     * 查询所有影片信息
     * @return
     */
    List<FilmPo> selectAllFilm();

    /**
     * 查询影片总数
     * @return
     */
    int selectTotalFilm(JSONObject json);

    /**
     * 分页查询影片信息
     * @param json
     * @return
     */
    List<FilmPo> selectByPageFilm(JSONObject json);

    /**
     * 编辑影片信息
     * @param json
     */
    void updateFilm(JSONObject json);

    /**
     * 添加影片
     * @param json
     */
    void insertFilm(JSONObject json);

    /**
     * 删除影片
     * @param json
     */
    void deleteFilm(JSONObject json);
}
