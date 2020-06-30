package com.controller;

import com.annotion.BaOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyq
 * @date 2020-04-08
 */
@Service
public class Service1 {

    @BaOperationLog
    public void a(){
//        return true;
    }

    public static void main(String[] args) {
        Map<String,String> map  = new HashMap<>(16);
        System.out.println(map);
    }
}
