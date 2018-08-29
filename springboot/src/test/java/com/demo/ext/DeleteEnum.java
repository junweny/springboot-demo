package com.demo.ext;


public enum DeleteEnum implements BaseEnum {

    DELETE("已删除"),
    NORMAL("正常");

    private final String key;

    DeleteEnum(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

