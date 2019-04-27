package org.courses.web;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.courses.data.DAO.NamedDao;
import org.courses.data.DAO.UnNamedDao;
import org.courses.data.DAO.hbm.StorageDao;
import org.courses.domain.hbm.Manufacture;
import org.courses.domain.hbm.Material;
import org.courses.domain.hbm.Socks;
import org.courses.domain.hbm.SocksType;
import org.courses.web.rest.services.TestService;
import org.courses.web.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.xml.ws.Endpoint;

@Configuration
@Import(org.courses.data.SpringConfig.class)
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class SpringConfig {

    //SOAP////////////////////////////////////////////////////////////
    @Autowired
    NamedDao<SocksType, Integer> typeDao;
    @Autowired
    NamedDao<Material, Integer> materialDao;
    @Autowired
    NamedDao<Manufacture, Integer> manufactureDao;
//    @Autowired
//    UnNamedDao<Socks, Integer> socksDao;



    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public TypeService soapTypeService() {
        return new ImplementationTypeService(typeDao);
    }

    @Bean
    public MaterialService soapMaterialService() {
        return new ImplementationMaterialService(materialDao);
    }

    @Bean
    public ManufactureService soapManufactureService() {
        return new ImplementationManufactureService(manufactureDao);
    }

//    @Bean
//    public SocksService soapSocksService() {
//        return new ImplementationSocksService(socksDao);
//    }

    @Bean
    public Endpoint typeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), soapTypeService());
        endpoint.publish("/typeservice");
        return endpoint;
    }

    @Bean
    public Endpoint materialEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), soapMaterialService());
        endpoint.publish("/materialservice");
        return endpoint;
    }

    @Bean
    public Endpoint ManufactureEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), soapManufactureService());
        endpoint.publish("/manufactureservice");
        return endpoint;
    }

//    @Bean
//    public Endpoint SocksEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(cxf(), soapSocksService());
//        endpoint.publish("/socksservice");
//        return endpoint;
//    }

    //REST////////////////////////////////////////////////////////////
    @Bean
    public TestService restTestService() {
        return new TestService();
    }


}
