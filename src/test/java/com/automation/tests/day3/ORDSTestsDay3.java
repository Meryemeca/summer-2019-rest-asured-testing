package com.automation.tests.day3;



import com.automation.utilities.ConfigurationReader;
import com.sun.xml.xsom.impl.scd.Iterators;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class ORDSTestsDay3 {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("ords.uri");
    }

    //accept("application/json") shortcut for header("Accept", "application/json")
    //we are asking for json as a response
    @Test
    public void test1() {
        given().
                accept("application/json").
                get("/employees").
                then().
                assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                log().all(true);
    }

    //path parameter - to point on specific resource /employee/:id/ - id it's a path parameter
    //query parameter - to filter results, or describe new resource :
    // POST /users?name=James&age=60&job-title=SDET
    //or to filter GET /employee?name=Jamal get all employees with name Jamal
    @Test
    public void test2() {
        given().
                accept("application/json").
                pathParam("id", 100).
                when().get("/employees/{id}").
                then().assertThat().statusCode(200).
                and().assertThat().body("employee_id", is(100),
                "department_id", is(90),
                "last_name", is("King")).
                log().all(true);
        //body ("phone_number") --> 515.123.4567
        //is is coming from ---> import static org.hamcrest.Matchers.*;
    }

    /**
     * given path parameter is "/regions/{id}"
     * when user makes get request
     * and region id is equals to 1
     * then assert that status code is 200
     * and assert that region name is Europe
     */

    @Test
    public void test3(){
        given().
                accept("application/json").
                pathParam("id", 1).

         when().
         get("/regions/{id}").
          then().
          assertThat().statusCode(200).
          assertThat().body("region_name", is("Europe")).
                time(lessThan(1L), TimeUnit.SECONDS).
        log().body(true);
    }

    @Test
    public void test4(){
       JsonPath json = given().accept("application/json").
                when().get("/employees").
                thenReturn().jsonPath();

       String nameOfFirstEmployee = json.getString("items[0].first_name");
      String nameOfLastEmployee= json.getString("items[-1].first_name");//-1 last index

        System.out.println("First employee name "+nameOfFirstEmployee);

        System.out.println("last employees name: "+nameOfLastEmployee);

        Map<String, ?> firstEmployee = json.get("items[0]");
        System.out.println(firstEmployee);

        for(Map.Entry<String,?> entry: firstEmployee.entrySet()){
            System.out.println("key" + entry.getKey()+" valeu: "+entry.getValue());
        }

        List<String> lastNames= json.get("items.last_name");
        for (String str: lastNames) {
            System.out.println("last name: "+str);
        }

    }


    @Test
    public void test5(){
        JsonPath json = given().accept("application/json").when().get("/countries").
                prettyPeek().jsonPath();
        List<HashMap<String, ?>> allCountries = json.get("items");
        System.out.println(allCountries);

        for(HashMap<String, ?> map : allCountries){
            System.out.println(map);
        }

    }

    @Test
    public void test6(){

        List <Integer> salaries = given().accept("application/json").when().
                get("/employees").thenReturn()
                .jsonPath().get("items.salary");


        // Correct notation Collections.sort(salaries,Collections.reverseOrder());
        Collections.sort(salaries);
        System.out.println(salaries);
        Collections.reverse(salaries);
        System.out.println(salaries);
    }

    //get collection of phone numbers, from employees
    //and replace all dots "." in every phone number with dash "-"
    @Test
    public void test7(){
        List<String> phoneNumbers=given().
                accept("application/json").
                when().get("/employees").
                thenReturn().jsonPath().get("items.phone_number");
//        Replaces each element of this list with the result of applying the operator to that element.
//        replace '.' with '-' in every value
        phoneNumbers.replaceAll(phone -> phone.toString().replace(".", "-"));
        System.out.println(phoneNumbers);

    }
    /**
     * Given accept type as JSON
     * And path parameter is id
     * When user verifies that status is 200
     * And user verifies that location_id 700
     * And user verifies that city is seattle
     * And user verifies that state_province is Washington
     *
     */

    @Test
    public void test8(){

       given().accept(ContentType.JSON).
               pathParam("id",1700).
               when().get("/locations/{id}").
               then().assertThat().body("location_id", is(1700),
               "postal_code",is("98199"),
               "city",is("Seattle"),
               "state_province",is("Washington")).
               log().body(true);
    }
}
