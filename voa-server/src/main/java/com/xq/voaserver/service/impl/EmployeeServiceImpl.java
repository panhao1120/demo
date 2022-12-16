package com.xq.voaserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.voaserver.mapper.EmployeeMapper;
import com.xq.voaserver.pojo.Employee;
import com.xq.voaserver.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
