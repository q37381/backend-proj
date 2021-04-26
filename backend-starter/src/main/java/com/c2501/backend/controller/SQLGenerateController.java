package com.c2501.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.common.service.SqlGenerateService;
import com.common.util.SQLToJavaFieldUtil;

@RestController
@RequestMapping("sqlGenerate")
public class SQLGenerateController {

    // TODOM 后期改成接口调用
    private SqlGenerateService sqlGenerateService = new SqlGenerateService();

    @PostMapping("/toJava")
    public String sqlToJava(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return null;
        }

        return SQLToJavaFieldUtil.getJavaFieldStr(sql);

    }

    @PostMapping("/wordToSql")
    public String wordToSql(String word) {
        if (StringUtils.isEmpty(word)) {
            return null;
        }

        return sqlGenerateService.generateSqlByWord(word);
    }
}
