package com.msa.sample.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Hello controller.
 *
 * @class:HelloController
 * @description:描述
 * @author:sxp
 * @date:2018/4/22 15 :45
 */
@RestController
public class HelloController {

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping(name = "HelloService", method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello";
    }
}
