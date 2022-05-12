package com.tigo.bo.GenerateInvoiceSain;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "generateInvoiceSainRequest")
    public DefaultWsdl11Definition defaultWsdl11Request(XsdSchema generateInvoiceSainRequestSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePortRequest");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/SAIN/GenerateInvoiceSainRequest/V1/schema");
        wsdl11Definition.setSchema(generateInvoiceSainRequestSchema);
        return wsdl11Definition;
    }

    @Bean(name = "generateInvoiceSainResponse")
    public DefaultWsdl11Definition defaultWsdl11Response(XsdSchema generateInvoiceSainResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePortResponse");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/SAIN/GenerateInvoiceSainResponse/V1/schema");
        wsdl11Definition.setSchema(generateInvoiceSainResponseSchema);
        return wsdl11Definition;
    }

    @Bean(name = "parameterTypeV2")
    public DefaultWsdl11Definition defaultWsdl11ParameterTypeV2Schema(XsdSchema parameterTypeV2Schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePortParameter");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/ParameterType/V2");
        wsdl11Definition.setSchema(parameterTypeV2Schema);
        return wsdl11Definition;
    }

    @Bean(name = "requestHeader")
    public DefaultWsdl11Definition defaultWsdl11RequestHeader(XsdSchema requestHeaderSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePortParameter");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/RequestHeader/V3");
        wsdl11Definition.setSchema(requestHeaderSchema);
        return wsdl11Definition;
    }

    @Bean(name = "responseHeaderV3")
    public DefaultWsdl11Definition defaultWsdl11ResponseHeaderV3(XsdSchema responseHeaderV3Schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePortParameter");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/ResponseHeader/V3");
        wsdl11Definition.setSchema(responseHeaderV3Schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema generateInvoiceSainRequestSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/GenerateInvoiceSainRequest.xsd"));
    }

    @Bean
    public XsdSchema generateInvoiceSainResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/GenerateInvoiceSainResponse.xsd"));
    }

    @Bean
    public XsdSchema parameterTypeV2Schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/ParameterTypeV2.xsd"));
    }

    @Bean
    public XsdSchema requestHeaderSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/RequestHeaderV3.xsd"));
    }

    @Bean
    public XsdSchema responseHeaderV3Schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/ResponseHeaderV3.xsd"));
    }
}
