package com.demo.flowable.controller;

import com.demo.flowable.domain.Approval;
import com.demo.flowable.domain.Article;
import com.demo.flowable.services.ArticleWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 03/12/2019
 */
@RestController
public class ArticleWorkflowController {

    private final ArticleWorkflowService service;

    @Autowired
    public ArticleWorkflowController(ArticleWorkflowService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public void submit(@RequestBody Article article) {
        service.startProcess(article);
    }

    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam String assignee) {
        return service.getTasks(assignee);
    }

    @PostMapping("/review")
    public void review(@RequestBody Approval approval) {
        service.submitReview(approval);
    }
}
