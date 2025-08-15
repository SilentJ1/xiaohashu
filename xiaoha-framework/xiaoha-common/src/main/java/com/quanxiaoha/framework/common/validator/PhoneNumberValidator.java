package com.quanxiaoha.framework.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * PhoneNumberValidator 是一个用于自定义校验注解 @PhoneNumber 的验证器类。
 * 它实现了 ConstraintValidator 接口，用于验证一个字符串是否符合特定的手机号格式。
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    // PhoneNumberValidator 类实现了 ConstraintValidator<PhoneNumber, String> 接口。
    // ConstraintValidator 接口有两个泛型参数：
    //  PhoneNumber：自定义注解类型。
    //  String：被校验的属性类型。

    /**
     * initialize 方法是用来执行初始化操作的。这个方法在校验器实例化后会被调用，
     * 通常用来读取注解中的参数来设置校验器的初始状态。在这里，我们没有任何初始化操作，所以方法体是空的。
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // 校验逻辑：正则表达式判断手机号是否为 11 位数字
        return phoneNumber != null && phoneNumber.matches("\\d{11}");
    }
}
