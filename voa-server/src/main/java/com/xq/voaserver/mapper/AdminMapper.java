package com.xq.voaserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xq.voaserver.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */

public interface AdminMapper extends BaseMapper<Admin> {

}
