package com.tigo.bo.GenerateInvoiceSain.endpoints;

import com.tigo.xmlns.sain.generateinvoicesainrequest.v1.schema.GenerateInvoiceSainRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GenerateInvoiceSainEndpoint {
    private static final String NAMESPACE_URI = "http://xmlns.tigo.com/SAIN/GenerateInvoiceSainRequest/V1/schema";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GenerateInvoiceSainRequest")
    @ResponsePayload
    public GenerateInvoiceSainRequest getData(@RequestPayload GenerateInvoiceSainRequest request) {
        return request;
    }
}
