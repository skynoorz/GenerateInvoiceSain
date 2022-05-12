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

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://tigo.com.bo/gen");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "generateInvoiceSainRequest")
    public DefaultWsdl11Definition defaultWsdl11(XsdSchema generateInvoiceSainRequestSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GenerateInvoicePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xmlns.tigo.com/SAIN/GenerateInvoiceSainRequest/V1/schema");
        wsdl11Definition.setSchema(generateInvoiceSainRequestSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    @Bean
    public XsdSchema generateInvoiceSainRequestSchema() {
        return new SimpleXsdSchema(new ClassPathResource("GenerateInvoiceSainRequest.xsd"));
    }

    @Bean
    public XsdSchema generateInvoiceSainResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("GenerateInvoiceSainResponse.xsd"));
    }

    @Bean
    public XsdSchema parameterTypeV2Schema() {
        return new SimpleXsdSchema(new ClassPathResource("ParameterTypeV2.xsd"));
    }

    @Bean
    public XsdSchema requestHeaderSchema() {
        return new SimpleXsdSchema(new ClassPathResource("RequestHeaderV3.xsd"));
    }

    @Bean
    public XsdSchema responseHeaderV3Schema() {
        return new SimpleXsdSchema(new ClassPathResource("ResponseHeaderV3.xsd"));
    }
}
