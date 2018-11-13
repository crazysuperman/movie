package com.csm.manager.film.web;

import com.alibaba.fastjson.JSONObject;
import com.csm.manager.film.pojo.po.FilmPo;
import com.csm.manager.film.service.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class FilmTable {
    @Autowired
    private FilmServiceImpl psi;

    /**
     * 获取所有电影信息并回调给前端
     * @return
     */
    @ResponseBody
    @PostMapping("/Films")
    public Object Films(){
        JSONObject json = new JSONObject();
        List<FilmPo> Films = psi.findAllFilm();
        json.put("list",Films);
        return json;
    }

    /**
     * 分页查询电影信息
     * @return
     */
    @ResponseBody
    @PostMapping("/pageFilms")
    public Object pageFilms(@RequestBody JSONObject json){
        json = psi.findByPageFilm(json);
        return json;
    }

    /**
     * 编辑电影信息
     * @return
     */
    @ResponseBody
    @PostMapping("/editFilm")
    public String editFilm(@RequestBody JSONObject json){
        psi.modifyFilm(json);
        return "1";
    }

    /**
     * 添加电影信息
     * @return
     */
    @ResponseBody
    @PostMapping("/addFilm")
    public String addFilm(@RequestBody JSONObject json){
        psi.addFilm(json);
        return "1";
    }

    /**
     * 删除电影信息
     * @return
     */
    @ResponseBody
    @PostMapping("/deleteFilm")
    public String deleteFilm(@RequestBody JSONObject json){
        psi.removeFilm(json);
        return "1";
    }

    @ResponseBody
    @PostMapping("/uploadPoster")
    public Map<String,Object> uploadPoster(@RequestParam MultipartFile file) {
        Map<String, Object> map = psi.uploadPoster(file);
        System.out.println(map.get("src"));
        return map;
    }
}


