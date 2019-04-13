package com.myspace;

import org.kie.submarine.process.impl.DefaultWorkItemHandlerConfig;

import com.myspace.onboarding.DecisionTaskWorkItemHandler;

public class WorkItemHandlerConfig extends DefaultWorkItemHandlerConfig  {{
    register("DecisionTask", new DecisionTaskWorkItemHandler());    
}}
