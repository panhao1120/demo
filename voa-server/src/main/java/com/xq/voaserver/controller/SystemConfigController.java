package com.xq.voaserver.controller;

import com.xq.voaserver.pojo.Menu;
import com.xq.voaserver.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统配置Controller
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    private IMenuService menuService;
    @ApiOperation(value = "通过用户id获取菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByAdminId();
    }
}
