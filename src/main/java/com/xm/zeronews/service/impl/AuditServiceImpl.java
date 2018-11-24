package com.xm.zeronews.service.impl;

import com.xm.zeronews.pojo.Audit;
import com.xm.zeronews.dao.AuditMapper;
import com.xm.zeronews.service.AuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class AuditServiceImpl extends ServiceImpl<AuditMapper, Audit> implements AuditService {

}
