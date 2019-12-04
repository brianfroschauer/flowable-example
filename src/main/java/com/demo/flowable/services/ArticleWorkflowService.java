package com.demo.flowable.services;

import com.demo.flowable.domain.Approval;
import com.demo.flowable.domain.Article;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: brianfroschauer
 * Date: 03/12/2019
 */
@Service
public class ArticleWorkflowService {

    private final RuntimeService runtimeService;
    private final TaskService taskService;

    @Autowired
    public ArticleWorkflowService(RuntimeService runtimeService,
                                  TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @Transactional
    public void startProcess(Article article) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        runtimeService.startProcessInstanceByKey("articleReview", variables);
    }

    @Transactional
    public List<Article> getTasks(String assignee) {
        final List<Task> tasks = taskService
                .createTaskQuery()
                .taskCandidateGroup(assignee)
                .list();

        return tasks
                .stream()
                .map(task -> {
                    final Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Article(task.getId(), (String) variables.get("author"), (String) variables.get("url"));
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void submitReview(Approval approval) {
        final Map<String, Object> variables = new HashMap<>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getId(), variables);
    }
}
