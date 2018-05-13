package com.msa.sample.registry;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * The type Service registry.
 *
 * @class:ServiceRegistryImpl
 * @description:描述
 * @author:sxp
 * @date:2018/4/22 15 :51
 */
@Slf4j
public class ServiceRegistryImpl implements ServiceRegistry, Watcher {

    /**
     * The constant latch.
     */
    private static final CountDownLatch latch = new CountDownLatch(1);

    /**
     * The Zk.
     */
    private ZooKeeper zk;

    /**
     * Instantiates a new Service registry.
     *
     * @param zkServers the zk servers
     */
    public ServiceRegistryImpl(String zkServers) {
        try {
            zk = new ZooKeeper(zkServers, 5000, this);
            latch.await();
            log.debug("connected to zookeeper");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册服务信息
     * Registry.
     *
     * @param serviceName    the service name
     * @param serviceAddress the service address
     */
    @Override
    public void registry(String serviceName, String serviceAddress) {
        try {
            // 创建持久注册跟节点
            String registryPath = "/registry";
            if(zk.exists(registryPath, false) == null) {
                zk.create(registryPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("create registry node:{}", registryPath);
            }

            // 创建持久服务节点
            String servicePath = registryPath + "/" + serviceName;
            if(zk.exists(servicePath, false) == null) {
                zk.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("create service node:{}", servicePath);
            }

            // 创建临时顺序节点
            String addressPath = servicePath + "/address-";
            String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            log.debug("create address node:{} => {}", addressNode, serviceAddress);
        } catch (Exception e) {
            log.error("create node failure", e);
        }
    }

    /**
     * Process.
     *
     * @param watchedEvent the watched event
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            latch.countDown();
        }
    }
}
