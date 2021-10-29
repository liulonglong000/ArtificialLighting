package com.face.log;

import java.lang.annotation.*;

/**
 * @author xiyb
 * @Description: 系统日志操作自定义注解
 * @date 2018/6/6 18:00
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    /**
     * 日志描述
     */
    String description()  default "";

    /**
     * 操作类型
     */
    String operateType() default "操作日志";

    /**
     * 操作状态
     * @return
     */
    boolean operateStatus() default true;

    /**
     * 模块名称
     * @return
     */
    String moduleName() default "";
}
