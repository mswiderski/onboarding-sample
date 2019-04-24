package com.myspace;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.process.WorkItemHandler;

import com.myspace.onboarding.DecisionTaskWorkItemHandler;

public class WorkItemHandlerConfig implements org.kie.submarine.process.WorkItemHandlerConfig {

    private final Map<String, WorkItemHandler> workItemHandlers = new HashMap<>();
    private final List<String> supportedHandlers = Arrays.asList("AssignDepartmentAndManager",
                                                                "CalculatePaymentDate",
                                                                "CalculateVacationDays",
                                                                "CalculateTaxRate",
                                                                "ValidateEmployee",
                                                                "AssignIdAndEmail",
                                                                "DecisionTask");
    
    @Override
    public WorkItemHandler forName(String name) {
                
        workItemHandlers.putIfAbsent("DecisionTask", new DecisionTaskWorkItemHandler());
        if (supportedHandlers.contains(name)) {
            // use decision task handler (single instance) for all supported handlers that are based on decision calls
            return workItemHandlers.get("DecisionTask");
        }
        
        return workItemHandlers.get(name);
    }

    @Override
    public Collection<String> names() {
        return supportedHandlers;
    }
}
