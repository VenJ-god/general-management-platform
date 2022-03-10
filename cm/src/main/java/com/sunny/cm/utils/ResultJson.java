package com.sunny.cm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 返回结果的通用类
 * @Author: Ven.J
 * @Date: 2022-03-04 16:20:49
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultJson {
    private int code;

    private String message;

    private Object data;

    public ResultJson(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
