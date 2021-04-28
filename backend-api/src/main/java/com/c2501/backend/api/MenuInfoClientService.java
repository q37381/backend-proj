package com.c2501.backend.api;

import java.util.List;

import com.c2501.backend.model.MenuInfoVO;

//@FeignClient
public interface MenuInfoClientService {

    List<MenuInfoVO> list();

}
