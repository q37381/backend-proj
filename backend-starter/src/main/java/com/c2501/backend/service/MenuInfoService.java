package com.c2501.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2501.backend.dao.MenuInfoDao;
import com.c2501.backend.model.MenuInfoVO;
import com.c2501.backend.po.MenuInfoPO;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<MenuInfoVO> list() {

        List<MenuInfoPO> list = menuInfoDao.list();

        return listMenuInfoVO(list);
    }

    private List<MenuInfoVO> listMenuInfoVO(List<MenuInfoPO> list) {
        List<MenuInfoVO> listVO = new ArrayList<>();
        for (MenuInfoPO menuInfo : list) {
            if (menuInfo.getParentId() == null) {
                MenuInfoVO vo = menuInfo.toMenuInfoVO();
                setChild(vo, list);

                listVO.add(vo);
            }
        }

        return listVO;
    }

    private void setChild(MenuInfoVO menuInfoVO, List<MenuInfoPO> list) {
        for (MenuInfoPO menuInfo : list) {
            Integer parentId = menuInfo.getParentId();
            if (parentId != null && parentId == menuInfoVO.getId()) {
                List<MenuInfoVO> child = menuInfoVO.getChild();
                if (child == null) {
                    child = new ArrayList<>();
                    menuInfoVO.setChild(child);
                }
                MenuInfoVO vo = menuInfo.toMenuInfoVO();
                child.add(vo);
                setChild(vo, list);
            }
        }
    }

}
