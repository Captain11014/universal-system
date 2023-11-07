package com.universal.system.model;

import com.universal.system.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 姓陈的
 * 2023/6/18 10:57
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SysLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     */
    private Long id;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 请求URL
     */
    private String operUrl;

    /**
     * 主机地址
     */
    private String operIp;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;
}