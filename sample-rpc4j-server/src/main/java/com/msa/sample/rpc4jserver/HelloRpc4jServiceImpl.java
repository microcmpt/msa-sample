package com.msa.sample.rpc4jserver;

import com.msa.rpc.server.annotation.RpcService;
import com.msa.sample.api.HelloRpc4jService;

/**
 * The type Hello rpc 4 j service.
 *
 * @ClassName: HelloRpc4jServiceImpl
 * @Author: sxp
 * @Date: 10 :20 2018/5/18
 * @Version: 1.0.0
 */
@RpcService(value = HelloRpc4jService.class)
public class HelloRpc4jServiceImpl implements HelloRpc4jService {
    /**
     * Hello string.
     *
     * @param str the str
     * @return the string
     */
    public String hello(String str) {
        return "Hello, " + str;
    }
}
