package com.universal.system.common.utils.annotation;

import java.lang.annotation.*;

/**
 * @author 姓陈的
 * 2023/6/17 20:42
 * 日志
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     * @return
     */
    String title() default "";

    /**
     * 操作类型
     * @return
     */
    String operate() default "";

}
