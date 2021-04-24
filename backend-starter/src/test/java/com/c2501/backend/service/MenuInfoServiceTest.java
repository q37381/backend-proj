package com.c2501.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.c2501.backend.po.MenuInfoPO;

class MenuInfoServiceTest {

    private final String RESULT = "[{\"id\":1,\"title\":\"常规管理\",\"icon\":\"fa fa-window-maximize\",\"href\":\"\",\"target\":\"_self\",\"child\":[{\"id\":2,\"title\":\"主页模板\",\"icon\":\"fa fa-window-maximize\",\"href\":\"\",\"target\":\"_self\",\"child\":[{\"id\":3,\"title\":\"主页一\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null},{\"id\":4,\"title\":\"主页二\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-2.html\",\"target\":\"_self\",\"child\":null},{\"id\":5,\"title\":\"主页三\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-3.html\",\"target\":\"_self\",\"child\":null}]},{\"id\":6,\"title\":\"菜单管理\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/menu.html\",\"target\":\"_self\",\"child\":null},{\"id\":7,\"title\":\"系统设置\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/setting.html\",\"target\":\"_self\",\"child\":null},{\"id\":8,\"title\":\"表格示例\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/table.html\",\"target\":\"_self\",\"child\":null},{\"id\":9,\"title\":\"表单示例\",\"icon\":\"fa fa-window-maximize\",\"href\":\"\",\"target\":\"_self\",\"child\":[{\"id\":10,\"title\":\"普通表单\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null},{\"id\":11,\"title\":\"分步表单\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null}]},{\"id\":12,\"title\":\"登录模板\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":[{\"id\":13,\"title\":\"登录-1\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null},{\"id\":14,\"title\":\"登录-2\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null},{\"id\":15,\"title\":\"登录-3\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null}]},{\"id\":16,\"title\":\"异常页面\",\"icon\":\"fa fa-window-maximize\",\"href\":\"page/welcome-1.html\",\"target\":\"_self\",\"child\":null}]}]";

    MenuInfoService ms = new MenuInfoService();

    @Test
    void test() {

        List<MenuInfoPO> list = new ArrayList<>();

        JSONArray parseArray = JSONObject.parseArray(RESULT);
        int size = parseArray.size();

        for (int i = 0; i < size; i++) {
            JSONObject vo = parseArray.getJSONObject(i);

            MenuInfoPO menuInfo = new MenuInfoPO();
            menuInfo.setId(vo.getIntValue("id"));
            menuInfo.setTitle(vo.getString("title"));
            menuInfo.setIcon(vo.getString("icon"));
            menuInfo.setHref(vo.getString("href"));

            setList(vo, menuInfo, list);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {

            // ms.getList2(list);
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    private void setList(JSONObject vo, MenuInfoPO menuInfo, List<MenuInfoPO> list) {

        list.add(menuInfo);
        JSONArray child = vo.getJSONArray("child");

        if (child != null) {
            int size = child.size();
            for (int i = 0; i < size; i++) {

                JSONObject jo = child.getJSONObject(i);

                MenuInfoPO mi = new MenuInfoPO();
                mi.setId(jo.getIntValue("id"));
                mi.setTitle(jo.getString("title"));
                mi.setIcon(jo.getString("icon"));
                mi.setHref(jo.getString("href"));
                mi.setParentId(menuInfo.getId());

                setList(jo, mi, list);
            }
        }

    }

}
