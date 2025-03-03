package com.local.credit.persistence.impl;

import com.local.credit.controller.dto.SaleInfoDto;
import com.local.credit.entities.Sale;
import com.local.credit.persistence.ISaleDao;
import com.local.credit.repository.SaleInfoRepository;
import com.local.credit.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaleDaoImpl implements ISaleDao {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    SaleInfoRepository SaleInfoRepository;

    @Override
    public List<Sale> findAll() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(int id) {
        return saleRepository.findById((long) id);
    }

    @Override
    public void save(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public void deleteById(int id) {
            saleRepository.deleteById((long)id);
    }

    @Override
    public List<SaleInfoDto> getSalesInfo() {
        return SaleInfoRepository.getSalesInfo();
    }
}
