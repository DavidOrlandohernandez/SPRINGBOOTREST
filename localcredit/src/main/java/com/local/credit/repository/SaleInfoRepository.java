package com.local.credit.repository;

import com.local.credit.controller.dto.SaleInfoDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleInfoRepository extends CrudRepository<SaleInfoDto, Integer>{

    @Query(value = "SELECT * FROM get_sales_info()", nativeQuery = true)
    List<SaleInfoDto> getSalesInfo();
}
