package com.quanxiaoha.framework.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {

    String message() default "手机号格式不正确, 需为 11 位数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

/**
 * @Target 注解用于指定自定义注解可以应用的 Java 元素类型。在 @PhoneNumber 中，@Target 的参数包括以下几个元素类型：
 * <p>
 * ElementType.METHOD：可以应用于方法。
 * ElementType.FIELD：可以应用于字段。
 * ElementType.ANNOTATION_TYPE：可以应用于其他注解。
 * ElementType.PARAMETER：可以应用于方法参数。
 * 这种组合使得 @PhoneNumber 注解可以被广泛使用在方法、字段、注解和参数上。
 * @Retention 注解用于指定自定义注解的保留策略。
 * RetentionPolicy.RUNTIME 表示该注解在运行时仍然可用（可以通过反射机制访问）。
 * 这对于校验注解非常重要，因为校验框架需要在运行时读取注解并执行相应的校验逻辑。
 * @Constraint 注解用于指定关联的验证器类。
 * 在 @PhoneNumber 中，validatedBy 属性指向 PhoneNumberValidator.class，
 * 即自定义注解 @PhoneNumber 使用 PhoneNumberValidator 类进行校验。
 * <p>
 * message 元素用于定义验证失败时的错误消息。在使用注解时可以覆盖默认消息。default 关键字用于提供该元素的默认值。
 * @Retention 注解用于指定自定义注解的保留策略。
 * RetentionPolicy.RUNTIME 表示该注解在运行时仍然可用（可以通过反射机制访问）。
 * 这对于校验注解非常重要，因为校验框架需要在运行时读取注解并执行相应的校验逻辑。
 * @Constraint 注解用于指定关联的验证器类。
 * 在 @PhoneNumber 中，validatedBy 属性指向 PhoneNumberValidator.class，
 * 即自定义注解 @PhoneNumber 使用 PhoneNumberValidator 类进行校验。
 * <p>
 * message 元素用于定义验证失败时的错误消息。在使用注解时可以覆盖默认消息。default 关键字用于提供该元素的默认值。
 */

/**
 * @Retention 注解用于指定自定义注解的保留策略。
 * RetentionPolicy.RUNTIME 表示该注解在运行时仍然可用（可以通过反射机制访问）。
 * 这对于校验注解非常重要，因为校验框架需要在运行时读取注解并执行相应的校验逻辑。
 */

/**
 * @Constraint 注解用于指定关联的验证器类。
 * 在 @PhoneNumber 中，validatedBy 属性指向 PhoneNumberValidator.class，
 * 即自定义注解 @PhoneNumber 使用 PhoneNumberValidator 类进行校验。
 */

/**
 * message 元素用于定义验证失败时的错误消息。在使用注解时可以覆盖默认消息。default 关键字用于提供该元素的默认值。
 */