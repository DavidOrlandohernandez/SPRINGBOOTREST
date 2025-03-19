package com.local.credit.service;

import com.local.credit.entities.Customer;
import com.local.credit.persistence.impl.CustomerDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void testFindById(){

        //Given
        Long id = 1L;

        //When
        when(this.customerDao.findById(anyLong())).thenReturn(DataProvider.optionalCustomerMock());
        Optional<Customer> optionalCustomer = this.customerService.findById(id);
        Customer customer = optionalCustomer.orElseThrow();

        //Then
        assertNotNull(optionalCustomer);
        assertNotNull(customer);
        assertEquals("David Orlando tres", customer.getName());
        verify(this.customerDao, times(1)).findById(anyLong()); // El verify solo se utiliza con la dependencia
    }

    @Test
    public void testSave(){
        //Given
        Customer customer = DataProvider.customerNewMock();
        //When
        this.customerService.save(customer);
        //Then
        ArgumentCaptor<Customer> playerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(this.customerDao).save(any(Customer.class));
        verify(this.customerDao).save(playerArgumentCaptor.capture());
        assertEquals(4L, playerArgumentCaptor.getValue().getId());
        assertEquals("David Orlando cuatro", playerArgumentCaptor.getValue().getName());
    }

   @Test
    public void testDeleteById(){
        //Given
        Long id = 1L;
        //When
        this.customerService.deleteById(id);
        System.out.println("-> Test Customer | Mocks | deleteById");
        //Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.customerDao).deleteById(anyLong());
        verify(this.customerDao).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());

    }
}
