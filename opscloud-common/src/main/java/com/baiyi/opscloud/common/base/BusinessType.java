package com.baiyi.opscloud.common.base;

/**
 * @Author baiyi
 * @Date 2020/2/22 5:46 下午
 * @Version 1.0
 */
public enum BusinessType {
    SERVER(1);

    private int type;

    BusinessType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}