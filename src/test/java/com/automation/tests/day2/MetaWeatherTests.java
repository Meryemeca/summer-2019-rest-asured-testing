package com.automation.tests.day2;


import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class MetaWeatherTests {

    private String baseURI ="https://www.metaweather.com/api/";


    @Test
    public void test1(){

        Response response = given().baseUri(baseURI+"location/search/")
                .queryParam("query","san")
                .get();

        assertEquals(200, response.getStatusCode());
        System.out.println(response.prettyPrint());



    }

    // /users/100/ - 100 it is a path parameter
    // /users/155/ - 155 it is a path parameter
    // / users/255?name=James | name - query parameter key=value, key it is a query parameter

    //first you need to search city then find the parameter of the city
    //then you can find the

    @Test
    public void test2(){
        Response response = given()
                .pathParam("woeid", "2487956")
                .get(baseURI+"location/{woeid}");
        System.out.println(response.prettyPrint());
    }

}
