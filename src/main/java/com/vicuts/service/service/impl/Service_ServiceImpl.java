package com.vicuts.service.service.impl;

import com.vicuts.service.dto.ResponseObject;
import com.vicuts.service.dto.ServiceDTO;
import com.vicuts.service.models.Service;
import com.vicuts.service.repository.ServiceRepository;
import com.vicuts.service.service.Service_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Service_ServiceImpl implements Service_Service {

    private final ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        List<Service> services = serviceRepository.findAll();
        return services;
    }

    @Override
    public ResponseObject save(ServiceDTO service) {

        ResponseObject res = new ResponseObject();
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setData(null);
        if (service.getName() == null || service.getName().trim().isEmpty()) {
            res.setMessage("Tên dịch vụ không được để trống!");
        } else if (service.getPrice() == null) {
            res.setMessage("Giá dịch vụ không được để trống!");
        } else if (!service.getPrice().chars().allMatch(Character::isDigit)) {
            res.setMessage("Giá dịch vụ phải là số!");
        } else {
            try {
                Service ser = new Service();
                ser.setName(service.getName());
                ser.setPrice(Integer.parseInt(service.getPrice()));
                ser.setDescription(service.getDescription());
                Service serv = serviceRepository.save(ser);

                return new ResponseObject(HttpStatus.OK.value(), "Thêm dịch vụ thành công!", serv, 1);
            } catch (Exception e) {
                return new ResponseObject(HttpStatus.OK.value(), e.getMessage(), null, 0);
            }
        }
        return res;
    }
}
