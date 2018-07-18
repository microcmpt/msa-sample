package com.github.microcmpt.client.service.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Cron task.
 */
@RestController
@RequestMapping(value = "/task")
public class CronTask {
    /**
     * Execute string.
     *
     * @return the string
     */
    @GetMapping(value = "/exec")
    public String execute() {
        try {
            System.out.println("execute start......");
            // 执行具体业务，建议如果执行的具体业务时间过长，最好用异步方式执行，否则会拖垮任务调度中心，导致线程资源耗尽
            Thread.sleep(10000);
            System.out.println("execute end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
