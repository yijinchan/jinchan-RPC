package com.jinchan.chanrpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * ClassName: ConfigUtils
 * Package: com.jinchan.chanrpc.utils
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/3/5 16:55
 */
public class ConfigUtils {
    /**
     * 加载配置对象
     *
     * @param clazz
     * @param prefix
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> clazz, String prefix) {
        return loadConfig(clazz, prefix, "");
    }

    /**
     * 加载配置对象，支持区分环境
     *
     * @param clazz 配置类的Class对象，用于创建配置对象的实例
     * @param prefix 配置项的前缀，用于指定配置对象中的属性键的前缀
     * @param environment 环境标识，用于区分不同环境的配置，如开发环境、生产环境等
     * @param <T> 配置对象的类型
     * @return 配置对象的实例，其属性值将根据提供的配置文件和前缀进行初始化
     */
    public static <T> T loadConfig(Class<T> clazz, String prefix, String environment) {
        // 构建配置文件名称，支持不同环境的配置文件
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        configFileBuilder.append(".properties");

        // 加载配置文件
        Props props = new Props(configFileBuilder.toString());
        // 将配置文件中的键值对映射到指定的配置对象上
        return props.toBean(clazz, prefix);
    }

}
