package com.xq.voaserver.config.security.component;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xq.voaserver.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author zyq
 * @Date 2022/12/14 11:26
 * @ClassName: ResultAuthenticationEntryPoint
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class ResultAuthenticationEntryPoint
        implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        RespBean bean = RespBean.error("未登录,请先登录");
        bean.setCode(401);
        PrintWriter out = response.getWriter();
        //new ObjectMapper().writeValueAsString(bean) 转json格式数据
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
