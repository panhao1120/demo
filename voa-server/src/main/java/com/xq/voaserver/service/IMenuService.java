package com.xq.voaserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xq.voaserver.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 通过用户id获取菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

}
