package com.xq.voaserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.voaserver.mapper.MailLogMapper;
import com.xq.voaserver.pojo.MailLog;
import com.xq.voaserver.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
