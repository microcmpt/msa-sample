package com.msa.sample;

import com.msa.rpc4j.annotation.Rpc4jClient;
import com.msa.sample.api.AddService;
import com.msa.sample.api.HelloRpc4jService;

/**
 * The interface Add service rpc client.
 */
@Rpc4jClient
public interface AddServiceRpcClient extends AddService {
}
