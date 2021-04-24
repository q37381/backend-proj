package com.c2501.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.common.util.SQLToJavaFieldUtil;

@RestController
@RequestMapping("sqlToJava")
public class SQLToJavaController {

    @PostMapping
    public String sqlToJava(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return null;
        }
        return SQLToJavaFieldUtil.getJavaFieldStr(sql);

    }
}
