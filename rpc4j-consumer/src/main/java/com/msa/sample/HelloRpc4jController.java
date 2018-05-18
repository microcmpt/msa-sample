package com.msa.sample;

import com.msa.sample.api.HelloRpc4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
