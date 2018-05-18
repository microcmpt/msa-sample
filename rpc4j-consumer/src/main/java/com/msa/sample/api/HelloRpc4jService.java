package com.msa.sample.api;

import com.msa.rpc4j.annotation.Rpc4jClient;

/**
 * The interface Hello rpc 4 j service.
 *
 * @ClassName: HelloRpc4jService
 * @Author: sxp
 * @Date: 9 :35 2018/5/18
 * @Version: 1.0.0
 */
@Rpc4jClient(name = "HelloRpc4jService")
public interface HelloRpc4jService {
    /**
     * Hello string.
     *
     * @param str the str
     * @return the string
     */
    String hello(String str);
}
