package cn.star.controller;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class mybatistest {


     /*   @Autowired
        ProcessEngine processEngine ;
        @Autowired
        RepositoryService repositoryService;
    @Test
    public void deploy() {
       *//* Deployment deployment = processEngine.getRepositoryService().createDeployment()
               .addClasspathResource("bpnm/Process-1.bpmn").addClasspathResource("bpnm/Process-1.png").deploy();
        System.out.println(
                deployment.getId()+"、、、、、、、、、、、"+deployment.getName()
        );*//*
        InputStream inputStreamBpmn = this.getClass().getResourceAsStream("Process-1.bpmn");
        InputStream inputStreamPng = this.getClass().getResourceAsStream("Process-1.png");
        *//*processEngine.getRepositoryService()//
                .createDeployment()//
                .addInputStream("userTask.bpmn", inputStreamBpmn)//
                .addInputStream("userTask.png", inputStreamPng)//
                .deploy();*//*

        repositoryService.createDeployment()//
                .addInputStream("userTask.bpmn", inputStreamBpmn)//
                .addInputStream("userTask.png", inputStreamPng)//
                .deploy();
    }*/
}