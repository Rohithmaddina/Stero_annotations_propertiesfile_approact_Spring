package org.example.controller;

import org.example.DTO.CustomerDto;
import org.example.Vo.CustomerVo;
import org.example.service.ICustomerMngtservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component(value = "controller")
public class Maincontroller {
    static
    {
        System.out.println("MainController.class is loading...");
    }
    public Maincontroller()
    {
        System.out.println("Maincontroller:: Zero param constructor");
    }
    @Autowired
    private ICustomerMngtservice service;
    public String processCustomer(CustomerVo customerVo)throws Exception
    {
        CustomerDto customerDto=new CustomerDto();
        customerDto.setCustomerName(customerVo.getCustomerName());
        customerDto.setCustomerAddress(customerDto.getCustomerAddress());
        customerDto.setPamt(Float.parseFloat(customerVo.getPamt()));
        customerDto.setRate(Float.parseFloat(customerVo.getRate()));
        customerDto.setTime(Float.parseFloat(customerVo.getRate()));
        String result=service.calculateSimpleInterest(customerDto);
        return result;
    }

}
