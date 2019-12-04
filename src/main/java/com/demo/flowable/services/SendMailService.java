package com.demo.flowable.services;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * Author: brianfroschauer
 * Date: 03/12/2019
 */
public class SendMailService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Sending rejection mail to author.");
    }
}
