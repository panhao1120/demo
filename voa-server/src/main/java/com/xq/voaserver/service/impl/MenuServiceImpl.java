package com.xq.voaserver.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.voaserver.config.security.RedisConfig;
import com.xq.voaserver.mapper.MenuMapper;
import com.xq.voaserver.pojo.Admin;
import com.xq.voaserver.pojo.Menu;
import com.xq.voaserver.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 通过用户id获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
         ValueOperations<String, Object> valueOperations =
                redisTemplate.opsForValue();
          //查询缓存中是否有数据
          List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
          if (CollectionUtils.isEmpty(menus)){
                    //如果没数据，数据库中查询，并设置到缓存中
         menus = menuMapper.getMenusByAdminId(adminId);
         valueOperations.set("menu_"+adminId,menus);
          }
          return menus;

    }
}
