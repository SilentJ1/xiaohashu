package com.quanxiaoha.framework.common.util;

import java.util.regex.Pattern;

/**
 * 参数校验工具类，提供常用的参数合法性校验方法
 *
 * @author quanxiaoha
 */
public final class ParamUtils {
    /**
     * 昵称最小长度
     */
    private static final int NICK_NAME_MIN_LENGTH = 2;

    // ============================== 校验昵称 ==============================
    /**
     * 昵称最大长度
     */
    private static final int NICK_NAME_MAX_LENGTH = 24;
    /**
     * 昵称中不允许出现的特殊字符正则表达式
     */
    private static final String NICK_NAME_REGEX = "[!@#$%^&*(),.?\":{}|<>]";
    /**
     * 预编译昵称正则表达式，提高性能
     */
    private static final Pattern NICK_NAME_PATTERN = Pattern.compile(NICK_NAME_REGEX);
    /**
     * 小哈书号最小长度
     */
    private static final int ID_MIN_LENGTH = 6;
    /**
     * 小哈书号最大长度
     */
    private static final int ID_MAX_LENGTH = 15;

    // ============================== 校验小哈书号 ==============================
    /**
     * 小哈书号正则表达式：只能包含字母、数字和下划线
     */
    private static final String ID_REGEX = "^[a-zA-Z0-9_]+$";
    /**
     * 预编译小哈书号正则表达式，提高性能
     */
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);

    // 私有构造函数，防止实例化
    private ParamUtils() {
        throw new AssertionError("工具类不允许实例化");
    }

    /**
     * 昵称校验
     * 规则：
     * 1. 长度在2-24个字符之间
     * 2. 不包含特殊字符 !@#$%^&*(),.?":{}|<>
     *
     * @param nickname 待校验的昵称
     * @return 校验通过返回true，否则返回false；如果参数为null也返回false
     */
    public static boolean checkNickname(String nickname) {
        // 先判断是否为null，避免空指针异常
        if (nickname == null) {
            return false;
        }

        // 检查长度
        int length = nickname.length();
        if (length < NICK_NAME_MIN_LENGTH || length > NICK_NAME_MAX_LENGTH) {
            return false;
        }

        // 检查是否含有特殊字符
        return !NICK_NAME_PATTERN.matcher(nickname).find();
    }

    /**
     * 小哈书ID校验
     * 规则：
     * 1. 长度在6-15个字符之间
     * 2. 只能包含字母、数字和下划线
     *
     * @param xiaohashuId 待校验的小哈书号
     * @return 校验通过返回true，否则返回false；如果参数为null也返回false
     */
    public static boolean checkXiaohashuId(String xiaohashuId) {
        // 先判断是否为null，避免空指针异常
        if (xiaohashuId == null) {
            return false;
        }

        // 检查长度
        int length = xiaohashuId.length();
        if (length < ID_MIN_LENGTH || length > ID_MAX_LENGTH) {
            return false;
        }

        // 检查格式
        return ID_PATTERN.matcher(xiaohashuId).matches();
    }

    /**
     * 字符串长度校验
     * 检查字符串是否非空且长度不超过指定值
     *
     * @param str    待校验的字符串
     * @param length 最大允许长度
     * @return 如果字符串为null或空字符串，返回false；如果长度超过限制，返回false；否则返回true
     */
    public static boolean checkLength(String str, int length) {
        // 处理null和空字符串的情况
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.length() <= length;
    }
}
