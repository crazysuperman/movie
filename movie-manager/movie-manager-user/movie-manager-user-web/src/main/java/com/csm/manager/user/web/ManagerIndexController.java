package com.csm.manager.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: GCC
 * @Github: https://github.com/littlechenchao
 * @Date: 2018/11/8 17:15
 * @Version 1.0
 */
@Controller
public class ManagerIndexController {

    @GetMapping("/{path}")
    public String toIndex(@PathVariable String path){
        return path;
    }
}
