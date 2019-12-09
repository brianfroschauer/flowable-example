package com.demo.flowable.services;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: brianfroschauer
 * Date: 09/12/2019
 */
public class SystemTaskA implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemTaskA.class);

    public SystemTaskA() {
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        LOGGER.info("System task A");
    }
}
