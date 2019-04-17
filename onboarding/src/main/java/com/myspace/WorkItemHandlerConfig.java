package com.myspace;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItemHandler;

import com.myspace.onboarding.DecisionTaskWorkItemHandler;

public class WorkItemHandlerConfig implements org.kie.submarine.process.WorkItemHandlerConfig {

    private final Map<String, WorkItemHandler> workItemHandlers = new HashMap<>();
    
    @Override
    public WorkItemHandler forName(String name) {
        if ("DecisionTask".equalsIgnoreCase(name)) {
            workItemHandlers.putIfAbsent(name, new DecisionTaskWorkItemHandler());
        }
        
        return workItemHandlers.get(name);
    }

    @Override
    public Collection<String> names() {
        return Collections.singletonList("DecisionTask");
    }
}
