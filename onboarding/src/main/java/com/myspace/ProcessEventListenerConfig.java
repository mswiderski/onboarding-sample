package com.myspace;

import org.kie.submarine.process.impl.DefaultProcessEventListenerConfig;

import ork.kie.addons.monitoring.process.PrometheusProcessEventListener;


public class ProcessEventListenerConfig extends DefaultProcessEventListenerConfig {
   
    public ProcessEventListenerConfig() {
        super(new PrometheusProcessEventListener("onboarding"));
    }
}
