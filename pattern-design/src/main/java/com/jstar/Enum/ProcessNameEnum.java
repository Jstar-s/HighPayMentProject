package com.jstar.Enum;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:22
 */
public enum ProcessNameEnum {


    USER_INFO_PROCESSOR("consumerProcessor");
    
    String name;


    ProcessNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
