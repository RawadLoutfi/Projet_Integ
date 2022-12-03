package com.projetInteg.studentGroup;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentGroupTest {

    @Test
    public void shouldPassIfGetResponseIsOk() throws Exception{
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = (HttpResponse) client.execute(new HttpGet("http://localhost:8083/api/v1/studentgroup"));
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200,statusCode);
    }
}

