package org.example.service;

import org.example.DTO.CustomerDto;

public interface ICustomerMngtservice {
    public String calculateSimpleInterest(CustomerDto dto) throws Exception;
}
