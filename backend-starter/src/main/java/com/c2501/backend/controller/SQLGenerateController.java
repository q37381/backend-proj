package com.c2501.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.c2501.sql.SQLHandleClientService;

@RestController
@RequestMapping("sqlGenerate")
public class SQLGenerateController {

    @Autowired
    private SQLHandleClientService SQLHandleClientService;

    @PostMapping("/toJava")
    public String sqlToJava(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return null;
        }

        return SQLHandleClientService.toJavaBean(sql);

    }

    @PostMapping("/wordToSql")
    public String wordToSql(String word) {
        if (StringUtils.isEmpty(word)) {
            return null;
        }

        return SQLHandleClientService.generateSQL(word);
    }
}
