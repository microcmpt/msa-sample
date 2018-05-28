package com.msa.sample;

import com.msa.rpc.server.annotation.RpcService;
import com.msa.sample.api.AddService;

/**
 * The type Add service.
 */
@RpcService(AddService.class)
public class AddServiceImpl implements AddService {
    /**
     * Add int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
