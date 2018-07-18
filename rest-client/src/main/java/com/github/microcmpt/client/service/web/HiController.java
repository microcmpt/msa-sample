package com.github.microcmpt.client.service.web;

import com.github.microcmpt.client.manager.HiServiceRpc4jService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The type Hi controller.
 */
@RestController
@RequestMapping("/api/")
public class HiController {
    /**
     * The Hi service rpc 4 j service.
     */
    @Resource
    HiServiceRpc4jService hiServiceRpc4jService;

    /**
     * Hi string.
     *
     * @param name the name
     * @return the string
     */
    @GetMapping(value = "/hi/{name}")
    public String hi(@PathVariable("name")String name) {
        return hiServiceRpc4jService.hi(name);
    }
}
