/**
 * Copyright (C), 2019-2019, 天骄山仔
 * FileName: ManageService
 * Author:   lenovo
 * Date:     2019/9/10 23:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chuangwei.internalAnswer.service;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/9/10
 * @since 1.0.0
 */
@Service
public class ManageService {
    public String getMessage(int userId) {
        return "Hello Message:" + String.valueOf(userId);
    }
}


