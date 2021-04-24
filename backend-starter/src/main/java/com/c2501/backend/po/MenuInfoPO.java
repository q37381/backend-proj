package com.c2501.backend.po;

import java.util.Date;

import com.c2501.backend.model.MenuInfoVO;

public class MenuInfoPO {

    private Integer id;

    private String title;

    private String icon;

    private String href;

    private Integer parentId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public MenuInfoVO toMenuInfoVO() {
        MenuInfoVO menuInfoVO = new MenuInfoVO();
        menuInfoVO.setId(id);
        menuInfoVO.setTitle(title);
        menuInfoVO.setIcon(icon);
        menuInfoVO.setHref(href);
        return menuInfoVO;
    }

}
