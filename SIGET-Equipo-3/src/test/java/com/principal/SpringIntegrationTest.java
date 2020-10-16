package com.principal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.principal.SigetEquipo3Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = SigetEquipo3Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public abstract class SpringIntegrationTest {
	
    protected RestTemplate restTemplate = new RestTemplate();

    protected final String DEFAULT_URL = "http://localhost:8080/";


}