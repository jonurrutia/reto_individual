package com.pruebas;

import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class Prueba {

    @org.junit.Test
    /*public void test1(){
        SmartPhoneServiceImpl s1 = new SmartPhoneServiceImpl();
        assertAll(() -> assertNotNull(s1.count(), "Es null"));
        assertAll(() -> assertTrue(s1.count()>0, "El numero tiene que ser mayor que 0"));
        assertAll(() -> assertEquals(3,s1.count().intValue(), "El numero deberia de es 3"));
    }*/
    public void test1(){
        SmartPhoneServiceImpl s1 = new SmartPhoneServiceImpl();
        Assertions.assertNotNull(s1.count(), "Es null");
        Assertions.assertTrue(s1.count()>0, "El numero tiene que ser mayor que 0");
        Assertions.assertEquals(3,s1.count().intValue(), "El numero deberia de es 3");
    }


    @org.junit.Test
    public void test2(){
        SmartPhoneServiceImpl s1 = new SmartPhoneServiceImpl();
        Long id=null;
        assertThrows(IllegalArgumentException.class,() -> {
            s1.findOne(id);
        });
    }


}
