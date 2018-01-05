package org.springstudy.springBoot;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springstudy.springBoot.rest.CustomerService;

@Configuration
public class CXFRestConfig {

	@Autowired
	private Bus bus;

	@Resource
	private CustomerService customerServiceHandler;

	@Bean
    public Server restServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/RestSimple");//为服务定义名称
        endpoint.setServiceBeans(Arrays.<Object>asList(customerServiceHandler));//注册服务提供类
        //让服务自动选择 JSON，XML
        endpoint.setProviders(Arrays.asList(jacksonJaxbJsonProvider(), jaxbElementProvider()));
        return endpoint.create();
    }

	@Bean
    public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
        return new JacksonJaxbJsonProvider();
    }

    @Bean
    public JAXBElementProvider jaxbElementProvider() {
        return new JAXBElementProvider();
    }
	
	
	
	
	
	
	
}
