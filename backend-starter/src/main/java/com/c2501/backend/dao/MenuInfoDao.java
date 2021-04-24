package com.c2501.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.c2501.backend.po.MenuInfoPO;

@Mapper
public interface MenuInfoDao {

    List<MenuInfoPO> list();
}
