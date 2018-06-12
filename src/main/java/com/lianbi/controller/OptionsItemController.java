package com.lianbi.controller;

import com.lianbi.service.OptionsItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/optionsitem")
public class OptionsItemController {

    private  static final Logger logger = LoggerFactory.getLogger(OptionsItemController.class);

    @Autowired
    private OptionsItemService optionsItemService;

    @RequestMapping("/list.action")
    public String select(ModelMap modelMap){
        modelMap.put("result","成功跳转页面");
        return "bookList";
    }



}
