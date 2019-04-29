/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myspace.hr;

public class DepartmentModel {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

//    public Map<String, Object> toMap() {
//        Map<String, Object> params = new HashMap();
//        params.put("employee", this.employee);
//        params.put("manager", this.manager);
//        params.put("department", this.department);
//        return params;
//    }
//
//    public void fromMap(Long id, Map<String, Object> params) {
//        this.id = id;
//        this.employee = (com.myspace.hr.Employee) params.get("employee");
//        this.manager = (java.lang.String) params.get("manager");
//        this.department = (java.lang.String) params.get("department");
//    }

    private com.myspace.hr.Employee employee;

    public com.myspace.hr.Employee getEmployee() {
        return employee;
    }

    public void setEmployee(com.myspace.hr.Employee employee) {
        this.employee = employee;
    }

    private java.lang.String manager;

    public java.lang.String getManager() {
        return manager;
    }

    public void setManager(java.lang.String manager) {
        this.manager = manager;
    }

    private java.lang.String department;

    public java.lang.String getDepartment() {
        return department;
    }

    public void setDepartment(java.lang.String department) {
        this.department = department;
    }
}

