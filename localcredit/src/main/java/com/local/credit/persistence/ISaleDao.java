package com.local.credit.persistence;

import com.local.credit.controller.dto.SaleInfoDto;
import com.local.credit.entities.Sale;
import com.local.credit.repository.SaleRepository;

import java.util.List;
import java.util.Optional;

public interface ISaleDao {

    List<Sale> findAll();

    Optional<Sale> findById(int id);

    void save(Sale sale);

    void deleteById(int id);

    List<SaleInfoDto> getSalesInfo();
}
