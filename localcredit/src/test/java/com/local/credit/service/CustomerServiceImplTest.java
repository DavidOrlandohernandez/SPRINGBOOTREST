package com.local.credit.service;

import com.local.credit.entities.Customer;
import com.local.credit.persistence.impl.CustomerDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerDaoImpl customerDao;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testFindAll(){
        //Given

        //When
        when(customerDao.findAll()).thenReturn(DataProvider.customerListMocks());
        List<Customer> customersList = customerService.findAll();

        //Then
        assertNotNull(customersList);
        assertFalse(customersList.isEmpty());
        assertEquals("David Orlando uno", customersList.get(0).getName());
        verify(this.customerDao).findAll();
    }
}
