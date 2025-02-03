package com.example.workflow.controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home() {
        return "Oh Johny";
    }

    @RequestMapping(value="/execute", method = RequestMethod.GET)
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("Process_0y4kdqm");
        // variable handling
        String item = "Computer";
        instance.setVariable("itemVariableName", item);


        //identify process calling bpm
        instance.businessKey("myProcessBusinessKey");

        instance.executeWithVariablesInReturn();
        return "bpm executed";
    }

    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public String tasks() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("Process_0pje9n8");

        instance.executeWithVariablesInReturn();
        return "task  executed";
    }
    ///executeBPM/sequenceflow_execute
    @RequestMapping(value="/executeBPM/{processByName}", method = RequestMethod.GET)
    public String execute(@PathVariable("processByName") String processByName) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey(processByName);

        instance.executeWithVariablesInReturn();
        return "bpm executed ::" + processByName;
    }
}
