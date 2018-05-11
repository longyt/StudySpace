package com.lianbi.core.base;

import com.lianbi.core.ResultDTO;
import com.lianbi.core.util.ServletUtil;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    public void outWrite(HttpServletResponse response, ResultDTO resultDTO){
        ServletUtil.write(response,resultDTO.toString());
    }

}
