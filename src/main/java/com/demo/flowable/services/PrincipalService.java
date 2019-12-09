package com.demo.flowable.services;

import com.demo.flowable.domain.Branch;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: brianfroschauer
 * Date: 09/12/2019
 */
@Service
public class PrincipalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrincipalService.class);
    private final RuntimeService runtimeService;
    private TaskService taskService;

    @Autowired
    public PrincipalService(RuntimeService runtimeService,
                            TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @Transactional
    public void startProcess(Branch branch) {
        final Map<String, Object> variables = new HashMap<>();

        variables.put("branch_name", branch.getName());
        runtimeService.startProcessInstanceByKey("systemTaskPrincipalModel", variables);
    }

    public long getTasks() {
        LOGGER.info("Get tasks");
        return taskService.createTaskQuery().count();
    }
}
