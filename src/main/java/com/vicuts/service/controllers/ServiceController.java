package com.vicuts.service.controllers;


import com.vicuts.service.common.Contant;
import com.vicuts.service.dto.ResponseObject;
import com.vicuts.service.dto.ServiceDTO;
import com.vicuts.service.models.Service;
import com.vicuts.service.service.Service_Service;
import io.jsonwebtoken.lang.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Contant.ROOT_PATH_SHOW + "/service")
@RequiredArgsConstructor
public class ServiceController {

    private final Service_Service service;

    @GetMapping()
    public ResponseEntity<ResponseObject> findAll(){
        List<Service> services = service.findAll();

        return ResponseEntity.ok().body(new ResponseObject(HttpStatus.OK.value(),"Thành công!",services, services.size()));
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResponseObject> insert( @RequestBody ServiceDTO entity) {
        return ResponseEntity.ok().body(service.save(entity));

    }
}
