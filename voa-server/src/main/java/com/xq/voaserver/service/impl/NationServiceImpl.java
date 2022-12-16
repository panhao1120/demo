package com.xq.voaserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.voaserver.mapper.NationMapper;
import com.xq.voaserver.pojo.Nation;
import com.xq.voaserver.service.INationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuqi
 * @since 2022-12-12
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
