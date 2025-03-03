package com.local.credit.service;

import com.local.credit.controller.dto.SaleInfoDto;
import com.local.credit.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleService {

    List<Sale> findAll();

    Optional<Sale> findById(int id);

    void save(Sale sale);

    void deleteById(int id);

    List<SaleInfoDto> getSalesInfo();
}
