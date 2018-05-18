package com.msa.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Hello rpc 4 j controller.
 *
 * @ClassName: HelloRpc4jController
 * @Author: sxp
 * @Date: 11 :42 2018/5/18
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/api")
public class HelloRpc4jController {
    /**
     * The Hello rpc 4 j service.
     */
    @Autowired
	private HelloServiceRpcClient helloServiceRpcClient;

    /**
     * Hello string.
     *
     * @param name the name
     * @return the string
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
    public String hello(@PathVariable("name")String name) {
        return helloServiceRpcClient.hello(name);
    }
}
