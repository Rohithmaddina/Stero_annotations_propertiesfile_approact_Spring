package org.example.service;

import org.example.DAO.ICustomerDao;
import org.example.DTO.CustomerDto;
import org.example.bo.CustomerBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "service")
public class CustomerMngtImpl implements ICustomerMngtservice{
    static {
        System.out.println("CustomerMngtImpl.class is loading...");
    }
    public CustomerMngtImpl()
    {
        System.out.println("CustomerMngtImpl :: zero argument constructor");
    }
    @Autowired
    private ICustomerDao dao;
    @Override
    public String calculateSimpleInterest(CustomerDto dto) throws Exception{
        float intrAmount=(dto.getPamt()*dto.getTime()*dto.getRate())/100.0f;
        CustomerBo customerBo=new CustomerBo();
        customerBo.setCustomerName(dto.getCustomerName());
        customerBo.setCustomerAddress(dto.getCustomerAddress());
        customerBo.setPamt(dto.getPamt());
        customerBo.setTime(dto.getTime());
        customerBo.setRate(dto.getRate());
        int count=dao.save(customerBo);
        return count == 0 ? "customer registration failed"
                : "customer registration succesfull---->SimpleInterestAmount::" + intrAmount;
    }
}
