package com.c2501.backend.model;

import java.util.List;

public class MenuInfoVO {

    private int id;

    private String title;

    private String icon;

    private String href;

    private String target = "_self";

    private List<MenuInfoVO> child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MenuInfoVO> getChild() {
        return child;
    }

    public void setChild(List<MenuInfoVO> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "MenuInfoVO [id=" + id + ", title=" + title + ", icon=" + icon + ", href=" + href + ", target=" + target
                + ", child=" + child + "]";
    }

}
