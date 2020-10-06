package com.xdj.interfaces.mallinterface.task;


import com.xdj.interfaces.mallinterface.service.LuceneService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Order(1)
@Component
public class ApplicationFun implements ApplicationRunner {
    @Resource
    private LuceneService luceneService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        luceneService.synProductCreatIndex();
    }
}
