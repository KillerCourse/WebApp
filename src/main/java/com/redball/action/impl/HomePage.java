package com.redball.action.impl;

import com.redball.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.redball.util.constant.ActionConstant.PRODUCT_JSP;

public class HomePage implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(PRODUCT_JSP);
    }
}
