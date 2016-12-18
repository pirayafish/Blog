package com.moli.core.interceptor;

import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moli.core.Const;
import com.moli.core.model.Response;
import com.moli.core.model.Response.ERROR;

/**
 * 新建类.
 * @author Lo&Wang
 */
@Component
public class SystemInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 后台session控制
        String[] noFilters = new String[]{"/api/login", "/api/reg"};
        String uri = request.getServletPath();
        if(1==1) return true;
        if (Arrays.asList(noFilters).contains(uri)) {
            return true;
        }
        if (request.getSession().getAttribute(Const.SESSION_USER) == null) {
            // 未登录
            PrintWriter out = response.getWriter();
            Response<String> res = new Response<>(ERROR.AUTH_ERROR, "页面过期，请重新登录");
            out.print(res.toJSONString());
            out.close();
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
