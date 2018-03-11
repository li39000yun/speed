package com.lyq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 云强 on 2018/3/8.
 */
@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * 测试hello
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
        return "user/user_list";
    }
}
