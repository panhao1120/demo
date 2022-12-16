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
 * @Author xq
 * @Date 2022/12/12 12:05
 * @ClassName: RestAuthenticationEntryPoint
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
 @Override
 public void commence(HttpServletRequest request, HttpServletResponse
         response, AuthenticationException authException) throws IOException,
    ServletException {
         response.setCharacterEncoding("UTF-8");
         response.setContentType("application/json");
         PrintWriter out = response.getWriter();
         RespBean bean = RespBean.error("权限不足，请联系管理员！");
        bean.setCode(401);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
