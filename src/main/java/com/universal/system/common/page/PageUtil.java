package com.universal.system.common.page;


import com.github.pagehelper.PageHelper;
import com.universal.system.common.utils.Convert;
import com.universal.system.common.utils.ServletUtil;

/**
 * @author 姓陈的
 * 2023/4/5 13:32
 * 分页工具类
 */
public class PageUtil extends PageHelper {


    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 分页参数合理化
     */
    public static final String REASONABLE = "reasonable";


    /**
     * 设置请求分页数据
     */
    public static void startPage(){

        Integer pageNum = Convert.toInt(ServletUtil.getParameter(PAGE_NUM),1);
        Integer pageSize = Convert.toInt(ServletUtil.getParameter(PAGE_SIZE),10);
//        Boolean reasonable = true;
        PageHelper.startPage(pageNum,pageSize).reasonable(true);

    }

    public static void clearPage(){
        PageHelper.clearPage();
    }


}
