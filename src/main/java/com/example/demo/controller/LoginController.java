package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.PO.MagicCube;
import com.example.demo.model.PO.User;
import liquibase.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/register")
    public String loginVefify(MagicCube mc) {
        Date date=new Date();
        mc.setCreateTime(date);
        mc.setUpdateTime(date);
        mc.setDeleteFlag(0);

       //String encryptPrice = MD5Util.computeMD5(mc.getPrice());
        //mc.setPrice(encryptPrice);

        userDao.addMagicCube(mc);
        System.out.println("user=[" + mc + "]");
        return "{\"status\":\"ok\"}";
    }



    @GetMapping("/sel")
    public MagicCube selectUser(String magicCubeName) {
        if (magicCubeName == null) {
            return null;
        } else {
            MagicCube mc  = userDao.getUserByMagicCubeName(magicCubeName);
            System.out.println("user=[" + mc + "]");
            return mc;
        }
    }

    @PostMapping("/update")
    public String updateUser(MagicCube mc) {
        userDao.updateMagicCube(mc);
        System.out.println("user=[" + mc + "]");
        return "{\"status\":\"ok\"}";
    }

    @DeleteMapping("/dell")
    public String deleteUser(String magicCubeName){
        userDao.delMagicCube(magicCubeName);
        return  "{\"status\":\"ok\"}";
    }
}
