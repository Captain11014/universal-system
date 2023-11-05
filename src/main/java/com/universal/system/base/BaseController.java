package com.universal.system.base;


import com.github.pagehelper.PageInfo;
import com.universal.system.common.page.PageUtil;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.model.login.LoginUser;

import java.util.List;

/**
 * @author 姓陈的
 * 2023/4/5 13:38
 */
public class BaseController {


    /**
     *  分页处理
     */
    protected void startPage(){
        PageUtil.startPage();
    }


    /**
     * 封装分页数据
     * @param list
     * @return
     */
    protected TableDataInfo getDataTable(List<?> list){
        PageInfo<?> pageInfo = new PageInfo<>(list);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setTotal(pageInfo.getTotal());
        return rspData;
    }

    /**
     * 返回成功消息
     * @return
     */
    protected AjaxResult success(){
        return AjaxResult.success();
    }

    /**
     * 返回成功消息
     * @return
     */
    protected AjaxResult success(String msg){
        return AjaxResult.success(msg);
    }

    /**
     * 返回成功消息
     * @return
     */
    protected AjaxResult success(Object data){
        return AjaxResult.success(data);
    }

    /**
     * 返回成功消息
     * @return
     */
    protected AjaxResult success(String msg ,Object data){
        return AjaxResult.success(msg,data);
    }

    /**
     * 返回失败消息
     * @return
     */
    protected AjaxResult error(){
        return AjaxResult.error();
    }

    /**
     * 返回失败消息
     * @return
     */
    protected AjaxResult error(String msg){
        return AjaxResult.error(msg);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.WARN, msg, data);
    }


    /**
     * 返回失败消息
     * @return
     */
    protected AjaxResult error(String msg,Object data){
        return AjaxResult.error(msg, data);
    }

    /**
     * 返回失败消息
     * @return
     */
    protected AjaxResult error(int code,String msg){
        return AjaxResult.error(code, msg);
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows){
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result){
        return result ? success() : error();
    }


    /**
     * 获取用户缓存信息
     */
    public LoginUser getLoginUser()
    {
        return SecurityUtil.getLoginUser();
    }

    /**
     * 获取登录用户id
     */
    public Long getUserId()
    {
        return getLoginUser().getSysUser().getUserId();
    }



    /**
     * 获取登录用户名
     */
    public String getUsername()
    {
        return getLoginUser().getUsername();
    }




}
