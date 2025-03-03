package com.local.credit.service;

import com.local.credit.controller.dto.SaleInfoDto;
import com.local.credit.entities.Sale;
import com.local.credit.persistence.ISaleDao;
import com.local.credit.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleDao salesService;

    @Override
    public List<Sale> findAll() {
        return salesService.findAll();
    }

    @Override
    public Optional<Sale> findById(int id) {
        return salesService.findById(id);
    }

    @Override
    public void save(Sale sale) {
        salesService.save(sale);
    }

    @Override
    public void deleteById(int id) {
        salesService.deleteById(id);
    }

    @Override
    public List<SaleInfoDto> getSalesInfo() {
        return salesService.getSalesInfo();
    }
}
