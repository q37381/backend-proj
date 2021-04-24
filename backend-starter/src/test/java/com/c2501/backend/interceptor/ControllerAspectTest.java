package com.c2501.backend.interceptor;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSONObject;

class ControllerAspectTest {

    @Test
    void test() {
        System.out.println(String.class.getCanonicalName());
        System.out.println(ControllerAspectTest.class.getName());
        System.out.println(ControllerAspectTest.class.getSimpleName());
        JSONObject.toJSONString(null);
    }

}
