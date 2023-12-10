package com.universal.system.base;


import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.page.PageUtil;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.model.login.LoginUser;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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



    /**
     * 导出excel数据文件
     * @param response
     * @param fileName 文件名
     * @param fieldList 要导出的字段集合
     * @param data 导出的数据
     * @throws IOException
     */
    public void exportExcel(HttpServletResponse response, String fileName, Class<?> c, Collection<String> fieldList, Collection<?> data)  {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), c).sheet().includeColumnFieldNames(fieldList).doWrite(data);
        } catch (IOException e) {
            throw new UniversalException(HttpStatus.ERROR,"数据导出失败，请联系管理员");
        }
    }
    /**
     * 导出excel数据文件
     * @param response
     * @param fieldList 要导出的字段集合
     * @param data 导出的数据
     * @throws IOException
     */
    public void exportExcel(HttpServletResponse response,  Class<?> c, Collection<String> fieldList, Collection<?> data)  {
       exportExcel(response,"excel数据",c,fieldList,data);
    }

    /**
     * 不创建对象（不需要在实体类添加注解）的导出
     * @param response 响应
     * @param fileName 文件名
     * @param fieldList 标题名
     * @param data 数据
     * @throws IOException
     */
    public void exportNoModelExcel(HttpServletResponse response,String fileName,List<List<String>> fieldList,Collection<?> data){
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream()).sheet().head(fieldList).doWrite(data);
        } catch (IOException e) {
            throw new UniversalException(HttpStatus.ERROR,"数据导出失败，请联系管理员");
        }

    }

    /**
     * 不创建对象（不需要在实体类添加注解）的导出
     * @param response 响应
     * @param fieldList 标题名
     * @param data 数据
     * @throws IOException
     */
    public void exportNoModelExcel(HttpServletResponse response,List<List<String>> fieldList,Collection<?> data){
        //文件名为默认值，前端未设置则使用
        exportNoModelExcel(response,"excel数据",fieldList,data);
    }

    /**
     * 构建到处excel需要的head
     * @param strList
     * @return
     */
    public List<List<String>> buildExcelHead(List<String> strList){
        List<List<String>> collect = strList.stream().map(str -> Arrays.asList(str)).collect(Collectors.toList());
        return collect;
    }


}
