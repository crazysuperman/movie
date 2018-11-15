package com.csm.manager.cinema.web;


import com.csm.manager.cinema.inter.CinemaInterface;
import com.csm.manager.cinema.pojo.dto.PageInfo;
import com.csm.manager.cinema.pojo.po.CinemaPO;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/cinema"})
public class CinemaController
{
    @Autowired
    private CinemaInterface ser;

    @RequestMapping({"/index"})
    public String toindex()
    {
        return "index";
    }

    @RequestMapping({"/list"})
    @ResponseBody
    public Object cinemaList(PageInfo pageInfo)
    {
        return this.ser.selectCinema(pageInfo);
    }

    @RequestMapping({"/deletecinema"})
    @ResponseBody
    public String deleteCinema(Integer cid)
    {
        String res = this.ser.deleteCinema(cid);
        return res;
    }

    @RequestMapping({"/delall"})
    @ResponseBody
    public String deleteaALL(int[] arr)
            throws Exception
    {
        String res = this.ser.deleteALL(arr);
        return res;
    }

    @RequestMapping({"/updatecinema"})
    @ResponseBody
    public String updateCinema(CinemaPO cinemaPO)
            throws Exception
    {
        System.out.print(cinemaPO.getCname() + "+++++++++");
        return this.ser.updateCinema(cinemaPO);
    }

    @RequestMapping({"/savecinema"})
    @ResponseBody
    public String saveCinema(CinemaPO cinemaPO)
            throws Exception
    {
        return this.ser.saveCinema(cinemaPO);
    }

    @RequestMapping({"/uploadimage"})
    @ResponseBody
    public String uploadImage(MultipartFile file)
            throws Exception
    {
        return this.ser.uploadImage(file);
    }
}
