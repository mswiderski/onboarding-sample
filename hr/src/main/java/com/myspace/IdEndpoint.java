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

package com.myspace;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.drools.modelcompiler.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;

import com.myspace.hr.IdModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/id")
@Api(description = "Id and Email service")
public class IdEndpoint {

    @Inject
    KieRuntimeBuilder runtimeBuilder;

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation("Assign employee id and email")
    public IdModel assignId(@ApiParam(value = "data model representing employee") IdModel resource) {
        KieSession ksession = runtimeBuilder.newKieSession("defaultStatelessKieSession");

        ksession.insert( resource );
        ksession.fireAllRules();

        return resource;
    }
}
