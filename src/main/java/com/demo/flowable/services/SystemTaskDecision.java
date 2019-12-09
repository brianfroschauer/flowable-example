package com.demo.flowable.services;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: brianfroschauer
 * Date: 09/12/2019
 */
@Component
public class SystemTaskDecision implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemTaskDecision.class);

    private final RuntimeService runtimeService;

    @Autowired
    public SystemTaskDecision(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        LOGGER.debug("System task decision");
        final String branchName = delegateExecution.getVariable("branch_name", String.class);

        switch (branchName) {
            case "A": startCaseA(); break;
            case "B": startCaseB(); break;
            default: throw new RuntimeException();
        }
    }

    private void startCaseA() {
        runtimeService.startProcessInstanceByKey("systemTaskAModel");
    }

    private void startCaseB() {
        runtimeService.startProcessInstanceByKey("systemTaskBModel");
    }
}
