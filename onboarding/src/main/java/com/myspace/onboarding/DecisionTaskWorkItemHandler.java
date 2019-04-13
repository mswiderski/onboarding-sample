package com.myspace.onboarding;

import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.submarine.cloud.workitems.DiscoveredServiceWorkItemHandler;
import org.kie.submarine.cloud.workitems.HttpMethods;

public class DecisionTaskWorkItemHandler extends DiscoveredServiceWorkItemHandler {

    private String namespace = System.getenv("NAMESPACE");

    public DecisionTaskWorkItemHandler() {
        if ("true".equalsIgnoreCase(System.getProperty("local"))) {
          this.serviceEndpoints.put("id", "http://localhost:8081/id");
          this.serviceEndpoints.put("department", "http://localhost:8081/department");
          this.serviceEndpoints.put("employeeValidation", "http://localhost:8081/employeeValidation");
          this.serviceEndpoints.put("vacationDays", "http://localhost:8082/vacationDays");
          this.serviceEndpoints.put("taxRate", "http://localhost:8082/taxRate");
          this.serviceEndpoints.put("paymentDate", "http://localhost:8082/paymentDate");
        }
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

        Map<String, Object> results = discoverAndCall(workItem, namespace, "Decision", HttpMethods.POST);

        manager.completeWorkItem(workItem.getId(), results);
    }


    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }

    @Override
    public String getName() {
        return "DecisionTask";
    }

}
