package controller;
import com.csm.common.util.PropKit;
import com.csm.common.util.StrKit;
import model.OrderDO;
import model.Plist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.OrderService;
import tools.FastDFSFile;
import tools.FastDFSUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService service;
    @ResponseBody
    @RequestMapping(value="/login")
    public String login(String username,String password){
        //System.out.print(username);
        //response.setHeader("Access-Control-Allow-Origin", "*");
        if(username.equals("xiaoming")&&password.equals("12345")){
            return "1";
        }else {
            return "0";
        }

    }
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page,Integer pageSize,String search){
        Plist plist = service.listPageOrder(page, pageSize,search);
        System.out.print(plist);
        return plist;
    }
    @RequestMapping("/delorder")
    @ResponseBody
    public int delOrder(OrderDO orderDO){

        int i = service.deleteOrder(orderDO);
        return i;
    }
    @RequestMapping("/delistorder")
    @ResponseBody
    public int delistOrder(Integer[] arr){
        if(arr[0] ==0){
            return 0;
        }
        int i = service.deleteListOrder(arr);
        return i;
    }
    @RequestMapping("/updateorder")
    @ResponseBody
    public int updateOrder(OrderDO orderDO){
        int i = service.updateOrder(orderDO);
        return i;
    }
    @RequestMapping("/saveeorder")
    @ResponseBody
    public int saveOrder(OrderDO orderDO){
        int i = service.saveOrder(orderDO);
        return i;
    }
    @ResponseBody
    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam MultipartFile file) {

        String path = "";
        try {
            //1. 形成实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //2. 调用工具类进行文件上传
            // remotePath： group1/M00/00/00/xxx.jpg
            String remotePath = FastDFSUtils.uploadFile(fastDFSFile);
            path = "http://47.99.93.91:8888/"+remotePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(path);
        return path;
    }

}
