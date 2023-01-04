package com.xq.voaserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xq.voaserver.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户id获取菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);


}
