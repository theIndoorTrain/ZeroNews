package com.xm.zeronews.service.impl;

import com.xm.zeronews.pojo.Emp;
import com.xm.zeronews.dao.EmpMapper;
import com.xm.zeronews.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 职工表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
