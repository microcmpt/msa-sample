package com.msa.sample.registry;

/**
 * The interface Service registry.
 *
 * @class:ServiceRegistry
 * @description:描述
 * @author:sxp
 * @date:2018/4/22 15 :48
 */
public interface ServiceRegistry {

    /**
     * 注册服务信息
     * Registry.
     *
     * @param serviceName    the service name
     * @param serviceAddress the service address
     */
    void registry(String serviceName, String serviceAddress);
}
