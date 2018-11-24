package com.xm.zeronews.service.impl;

import com.xm.zeronews.pojo.Love;
import com.xm.zeronews.dao.LoveMapper;
import com.xm.zeronews.service.LoveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Service
public class LoveServiceImpl extends ServiceImpl<LoveMapper, Love> implements LoveService {

}
