package com.xq.voaserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xq.voaserver.pojo.Admin;
import com.xq.voaserver.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest
            request);

    Admin getAdminByUserName(String username);
}
