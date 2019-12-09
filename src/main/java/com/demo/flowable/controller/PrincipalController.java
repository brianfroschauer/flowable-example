package com.demo.flowable.controller;

import com.demo.flowable.domain.Branch;
import com.demo.flowable.services.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: brianfroschauer
 * Date: 09/12/2019
 */
@RestController
public class PrincipalController {

    private final PrincipalService principalService;

    @Autowired
    public PrincipalController(PrincipalService principalService) {
        this.principalService = principalService;
    }

    @PostMapping("/submit")
    public void submit(@RequestBody Branch branch) {
        principalService.startProcess(branch);
    }

    @GetMapping("/tasks")
    public Long getTasks() {
        return principalService.getTasks();
    }
}
