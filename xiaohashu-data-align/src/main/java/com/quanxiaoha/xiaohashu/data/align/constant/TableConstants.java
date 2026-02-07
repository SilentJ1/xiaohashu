package com.quanxiaoha.xiaohashu.data.align.constant;

public class TableConstants {

    /**
     * 分隔符
     */
    private static final String TABLE_NAME_SEPARATE = "_";

    /**
     * 拼接表名后缀
     * @param date
     * @param hashKey
     * @return
     */
    public static String buildTableNameSuffix(String date, long hashKey) {
        return date + TABLE_NAME_SEPARATE + hashKey;
    }
}
