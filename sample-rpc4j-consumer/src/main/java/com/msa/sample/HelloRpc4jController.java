package com.msa.sample;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Resource
	private HelloServiceRpcClient helloServiceRpcClient;

    /**
     * The Add service rpc client.
     */
    @Resource
    private AddServiceRpcClient addServiceRpcClient;

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

    /**
     * Hello string.
     *
     * @param a the a
     * @param b the b
     * @return the string
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add/{a}/{b}")
    public String hello(@PathVariable("a")int a, @PathVariable("b")int b) {
        int result = addServiceRpcClient.add(a, b);
        return a + "+" + b + "=" + result;
    }
}
