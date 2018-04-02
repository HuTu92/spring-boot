package com.github.fnpac.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by liuchunlong on 2018/2/3.
 */
@Service
public class AsyncTaskService {

    private static final Logger logger = Logger.getLogger(AsyncTaskService.class.getName());

    @Async
    public void executeAsyncTask(int i) {
        logger.info("执行异步任务：" + i);
    }
}
