/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.dmn.submarine.quarkus.example;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.submarine.rest.quarkus.DMNResult;
import org.kie.dmn.submarine.rest.quarkus.DMNSubmarineQuarkus;

@Path("/paymentDate")
public class PaymentDateDMNEndpoint {

    static final DMNRuntime dmnRuntime = DMNSubmarineQuarkus.createGenericDMNRuntime();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> dmn(Map<String, Object> dmnContext) {
        DMNResult evaluate = DMNSubmarineQuarkus.evaluate(dmnRuntime, "paymentDate", dmnContext);
        return evaluate.getDmnContext();
    }

}
