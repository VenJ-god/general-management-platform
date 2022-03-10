package com.sunny.cm.entity.system;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 15:20:25
 **/
@Data
@NoArgsConstructor
public class Permission {

    private String id;

    private String type;

    private String name;
}
