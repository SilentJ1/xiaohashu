package com.quanxiaoha.framework.biz.operationlog.aspect;

import java.lang.annotation.*;

/**
 * 接口操作日志注解
 * 标记需要记录操作日志的方法，结合 ApiOperationLogAspect 实现自动日志记录
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时生效，AOP可解析
@Target({ElementType.METHOD})       // 仅作用于方法
@Documented                         // 生成Javadoc时包含该注解
public @interface ApiOperationLog {
    /**
     * API 功能描述（日志中展示的接口说明）
     *
     * @return 接口功能描述
     */
    String description() default "";
}