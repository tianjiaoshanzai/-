/**
 * Copyright (C), 2019-2019, 天骄山仔
 * FileName: SettingController
 * Author:   lenovo
 * Date:     2019/9/10 23:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chuangwei.internalAnswer.controller;

import com.chuangwei.internalAnswer.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/9/10
 * @since 1.0.0
 */
@Controller
public class SettingController {
    @Autowired
    ManageService manageService;

    @RequestMapping(path = {"/setting"}, method = {RequestMethod.GET})
    @ResponseBody
    public String setting(HttpSession httpSession) {
        return "Setting OK. " + manageService.getMessage(1);
    }
}
