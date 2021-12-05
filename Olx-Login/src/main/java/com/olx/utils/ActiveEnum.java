package com.olx.utils;

public enum ActiveEnum {

	TRUE(0),
    FALSE(1);

    public final int state;

    ActiveEnum(int i) {
        this.state = i;
    }
}
