package com.universal.system.service.impl;

import com.universal.system.mapper.SysLogMapper;
import com.universal.system.model.SysLog;
import com.universal.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 姓陈的
 * 2023/6/18 12:52
 */
@Service
public class SysLogServiceImpl implements SysLogService
{
    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * 查询系统日志
     * @param id 系统日志主键
     * @return 系统日志
     */
    @Override
    public SysLog selectSysLogById(Long id)
    {
        return sysLogMapper.selectSysLogById(id);
    }

    /**
     * 查询系统日志列表
     *
     * @param sysLog 系统日志
     * @return 系统日志
     */
    @Override
    public List<SysLog> selectSysLogList(SysLog sysLog)
    {
        return sysLogMapper.selectSysLogList(sysLog);
    }

    /**
     * 新增系统日志
     *
     * @param sysLog 系统日志
     * @return 结果
     */
    @Override
    public int insertSysLog(SysLog sysLog)
    {
        return sysLogMapper.insertSysLog(sysLog);
    }

    /**
     * 修改系统日志
     *
     * @param sysLog 系统日志
     * @return 结果
     */
//    @Override
//    public int updateSysLog(SysLog sysLog)
//    {
//        return sysLogMapper.updateSysLog(sysLog);
//    }

    /**
     * 批量删除系统日志
     *
     * @param ids 需要删除的系统日志主键
     * @return 结果
     */
    @Override
    public int deleteSysLogByIds(Long[] ids)
    {
        return sysLogMapper.deleteSysLogByIds(ids);
    }

    /**
     * 删除系统日志信息
     *
     * @param id 系统日志主键
     * @return 结果
     */
    @Override
    public int deleteSysLogById(Long id)
    {
        return sysLogMapper.deleteSysLogById(id);
    }
}