package com.c2501.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c2501.backend.model.MenuInfoVO;
import com.c2501.backend.service.MenuInfoService;
import com.common.constant.SomeEnums.DASErrorCode;
import com.common.exce.DASRuntimeException;

@RestController
@RequestMapping("menuInfo")
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @GetMapping
    public Map<String, Object> list(Integer ii) {
        List<MenuInfoVO> list = menuInfoService.list();
        // 测试报错
        if (ii != null) {
        @SuppressWarnings("unused")
        int i = 1 / ii;
        }
        return getReturnMenuMap(list);
    }

    @GetMapping("/testError")
    public Map<String, Object> testError() {
        throw new DASRuntimeException(DASErrorCode.UNKNOWN_ERROR);
    }

    private Map<String, Object> getReturnMenuMap(List<MenuInfoVO> list) {
        Map<String, Object> map = new HashMap<>();

        Map<String, Object> map1 = new HashMap<>();

        map1.put("title", "首页");
        map1.put("href", "");

        map.put("homeInfo", map1);

        Map<String, Object> map2 = new HashMap<>();

        map2.put("title", "首页");
        map2.put("image", "images/logo.png");
        map2.put("href", "");

        map.put("logoInfo", map2);

        map.put("menuInfo", list);

        return map;
    }

}
