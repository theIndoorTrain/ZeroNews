package com.xm.zeronews.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xm.zeronews.dto.AuditDto;
import com.xm.zeronews.dto.DtoMapper;
import com.xm.zeronews.dto.EmpDto;
import com.xm.zeronews.dto.NewsDto;
import com.xm.zeronews.pojo.Audit;
import com.xm.zeronews.pojo.Emp;
import com.xm.zeronews.pojo.News;
import com.xm.zeronews.service.AuditService;
import com.xm.zeronews.service.EmpService;
import com.xm.zeronews.service.NewsService;
import com.xm.zeronews.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 审核表 前端控制器
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Api(value="AuditController",tags="审核管理")
@CrossOrigin
@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private DtoMapper mapper;
    @Autowired
    private AuditService auditService;
    @Autowired
    private EmpService empService;
    @Autowired
    private NewsService newsService;

    @ApiOperation(value="审核新闻")
    @PutMapping("/news")
    public void auditNews(@RequestBody AuditDto auditDto) {
        if(null != auditDto) {
            Audit audit = mapper.dtoToAudit(auditDto);
            Emp emp = empService.getOne(new QueryWrapper<Emp>().eq("userId",UserUtil.getUserId()));
            audit.setAuditNum(emp.getNum());
            audit.setCreateTime(LocalDateTime.now());
            auditService.save(audit);
            News news = newsService.getById(audit.getNewsId());
            news.setStatus(auditDto.getIsAgree()==true?5:4);
            newsService.updateById(news);
        }
    }

    @ApiOperation(value="获取发布待审核的新闻")
    @GetMapping("/getNews")
    public NewsDto setAudit() {
        News news = newsService.getDisAuditNewsId();
        if(null == news) {
            return null;
        }
        return mapper.newsToDto(news);
    }

    @ApiOperation(value="审核用户申请")
    @PutMapping("/emp")
    public void setEmp(@RequestBody EmpDto empdto) {
        if(null != empdto) {
            Emp emp = mapper.dtoToEmp(empdto);
            Emp audit = empService.getOne(new QueryWrapper<Emp>().eq("userId",UserUtil.getUserId()));
            emp.setAuditNum(audit.getNum());
            empService.update(emp,new QueryWrapper<Emp>().eq("userId",emp.getUserId()));
        }
    }

}

