package com.vicuts.service.service;

import com.vicuts.service.dto.ResponseObject;
import com.vicuts.service.dto.ServiceDTO;
import com.vicuts.service.models.Service;
import org.springframework.stereotype.Component;

import java.util.List;

public interface Service_Service {
    List<Service> findAll();
    ResponseObject save(ServiceDTO service);
}
