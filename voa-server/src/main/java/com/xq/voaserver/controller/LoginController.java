package com.xq.voaserver.controller;

import com.xq.voaserver.pojo.Admin;
import com.xq.voaserver.pojo.AdminLoginParam;
import com.xq.voaserver.pojo.RespBean;
import com.xq.voaserver.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录控制器
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam,
       HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(),
                adminLoginParam.getPassword(),
                adminLoginParam.getCode(), request);

    }
    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功！");
    }
}
