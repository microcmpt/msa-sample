package com.github.microcmpt.rpc4j.server.services;

import com.github.microcmpt.server.api.HiService;
import com.msa.rpc.server.annotation.RpcService;

/**
 * The type Hi service.
 */
@RpcService(value = HiService.class)
public class HiServiceImpl implements HiService {
    /**
     * Hi string.
     *
     * @param name the name
     * @return the string
     */
    @Override
    public String hi(String name) {
        return "Hi, " + name;
    }
}
