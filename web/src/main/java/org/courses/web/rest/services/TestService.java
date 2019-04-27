package org.courses.web.rest.services;

import org.courses.data.DAO.hbm.StorageDao;
import org.courses.data.DAO.hbm.UnNamedBaseDao;
import org.courses.domain.hbm.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
//@RequestMapping("/dbtest")
public class TestService {

    @Autowired
    private UnNamedBaseDao<Storage,Integer> storageDao;
//
//    public TestService( stDao) {
//        storageDao =
//    }

        @GetMapping(value ="/greeting")
    public ResponseEntity greeting(@RequestParam(value ="connectionstring") String connectionString) {
        HttpStatus status = null == connectionString ?
                 HttpStatus.BAD_REQUEST : HttpStatus.OK ;
        return new ResponseEntity(connectionString,status);
    }

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/storages",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Collection<Storage> getStorages() {
        Collection<Storage> storageCollection = storageDao.readAll();
        return storageCollection;
    }


}
