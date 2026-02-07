package com.quanxiaoha.framework.common.util;

import cn.hutool.core.lang.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class JsonUtils {

    /**
     * private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();: 创建了一个私有的静态不可变的 ObjectMapper 实例，ObjectMapper 是 Jackson 库中用于序列化和反序列化 JSON 的核心类。
     * static { ... }: 这是一个静态初始化块，用于在类加载时执行一些初始化操作。在这里，OBJECT_MAPP  ER 被配置以在反序列化时忽略未知属性和在序列化时忽略空的 Java Bean 属性，并且注册了一个 JavaTimeModule 模块，用于解决 LocalDateTime 类型的序列化问题。
     * public static String toJsonString(Object obj) { ... }: 这是一个公共静态方法，用于将给定的 Java 对象序列化为 JSON 字符串。它接受一个 Object 类型的参数 obj，并使用 OBJECT_MAPPER 将其转换为 JSON 字符串并返回。
     *
     * @SneakyThrows: 这是 Lombok 提供的一个注解，用于简化异常处理。它会将被标注的方法中的受检异常转换为不受检异常，使得代码看起来更加简洁。
     */
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        OBJECT_MAPPER.registerModules(new JavaTimeModule()); // 解决 LocalDateTime 的序列化问题
    }

    /**
     * 初始化：统一使用 Spring Boot 个性化配置的 ObjectMapper
     *
     * @param objectMapper
     */
    public static void init(ObjectMapper objectMapper) {
        OBJECT_MAPPER = objectMapper;
    }

    /**
     * 将对象转换为JSON字符串
     */
    @SneakyThrows
    public static String toJsonString(Object object) {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    @SneakyThrows
    public static <T> T parseObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    /**
     * 将 JSON 字符串转换为 Map
     *
     * @param jsonStr
     * @param keyClass
     * @param valueClass
     * @param <K>
     * @param <V>
     * @return
     * @throws Exception
     */
    public static <K, V> Map<K, V> parseMap(String jsonStr, Class<K> keyClass, Class<V> valueClass) throws Exception {
        // 创建 TypeReference，指定泛型类型
        TypeReference<Map<K, V>> typeRef = new TypeReference<Map<K, V>>() {
        };

        // 将 JSON 字符串转换为 Map
        return OBJECT_MAPPER.readValue(jsonStr, OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyClass, valueClass));
    }

    /**
     * 将 JSON 字符串解析为指定类型的 List 对象
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> parseList(String jsonStr, Class<T> clazz) throws Exception {
        // 使用 TypeReference 指定 List<T> 的泛型类型
        return OBJECT_MAPPER.readValue(jsonStr, new TypeReference<List<T>>() {
            @Override
            public CollectionType getType() {
                return OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);
            }
        }.getType());
    }
}
