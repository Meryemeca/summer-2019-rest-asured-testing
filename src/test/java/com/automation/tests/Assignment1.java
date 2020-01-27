package com.automation.tests;

import com.automation.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class Assignment1 {
    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("https://uinames.com/");
    }

    @Test
    public void noParamsTest(){

//         given().
//                accept("application/json").
//                then().
//                assertThat().statusCode(200).
//                and().assertThat().contentType("application/json").
//                log().all(true);





    }








}
