package com.licy.fontscale.moudle.typeface.bean;

import android.graphics.Typeface;

/**
 * TypeFaceBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class TypeFaceBean {

    private String content;
    private Typeface typeface;
    private int code;
    private String name;

    public TypeFaceBean(String content, Typeface typeface, int code, String name) {
        this.content = content;
        this.typeface = typeface;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeFaceBean{" +
                "content='" + content + '\'' +
                ", typeface=" + typeface +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
