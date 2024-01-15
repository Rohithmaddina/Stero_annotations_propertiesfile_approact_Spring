package org.example.DAO;

import org.example.bo.CustomerBo;

public interface ICustomerDao {
    public int save(CustomerBo bo)throws Exception;
}
