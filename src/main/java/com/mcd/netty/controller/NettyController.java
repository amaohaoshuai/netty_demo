package com.mcd.netty.controller;

import com.mcd.netty.service.NettyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/netty")
public class NettyController {
    private static final Logger log = LoggerFactory.getLogger(NettyController.class);

    @Autowired
    private NettyService nettyService;

    @RequestMapping(value = "/getMessage")
    public Map<String,Object> getMessage(){
        log.info("test");
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("message", nettyService.getAllFacility());
        return modelMap;
    }

}
