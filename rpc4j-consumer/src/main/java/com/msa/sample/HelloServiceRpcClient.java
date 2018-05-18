package com.msa.sample;

import com.msa.rpc4j.annotation.Rpc4jClient;
import com.msa.sample.api.HelloRpc4jService;

/**
 * @ClassName: HelloServiceRpcClient
 * @Author: sxp
 * @Date: 15:07 2018/5/18
 * @Version: 1.0.0
 */
@Rpc4jClient
public interface HelloServiceRpcClient extends HelloRpc4jService {
}
