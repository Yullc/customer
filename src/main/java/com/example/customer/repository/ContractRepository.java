package com.example.customer.repository;

import com.example.customer.vo.Contract;
import com.example.customer.vo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContractRepository {

    List<String> getAllCustomerNames();

    Customer getCustomerByName(String name);

    List<String> getAllProducts();

    List<String> getAllAdmins();

    List<Contract> getContractsByCustomer(String customerCode);

    int insertContract(Contract contract);

    int deleteContract(@Param("customerCode") String customerCode,
                       @Param("contractName") String contractName,
                       @Param("regDate") Date regDate);
}
