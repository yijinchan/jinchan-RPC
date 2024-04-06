package com.jinchan.chanrpc.model;

/**
 * ClassName: ServiceMetaInfo
 * Package: com.jinchan.chanrpc.model
 * Description:
 *
 * @Author yijinchan
 * @Create 2024/4/3 20:25
 */

import cn.hutool.core.util.StrUtil;
import com.jinchan.chanrpc.constant.RpcConstant;
import lombok.Data;

/**
 * 注册元信息
 */
@Data
public class ServiceMetaInfo {
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务版本号
     */
    private String serviceVersion = RpcConstant.DEFAULT_SERVICE_VERSION;
    /**
     * 服务域名
     */
    private String serviceHost;
    /**
     * 服务端口
     */
    private Integer servicePort;
    /**
     * 服务分组（暂未实现）
     */
    private String serviceGroup = "default";

    /**
     * 获取服务键名
     * @return
     */
    public String getServiceKey() {
        //保留group字段
        //return String.format("%s:%s:%s",serviceName,serviceVersion,serviceGroup);
        return String.format("%s:%s",serviceName,serviceVersion);
    }

    /**
     * 获取服务节点键名
     * @return
     */
    public String getServiceNodeKey(){
        return String.format("%s/%s:%s",getServiceKey(),serviceHost,servicePort);
    }
    public String getServiceAddress(){
        if(!StrUtil.contains(serviceHost,"http")){
            return String.format("http://%s:%s",serviceHost,servicePort);
        }
        return String.format("%s:%s",serviceHost,servicePort);
    }
}
