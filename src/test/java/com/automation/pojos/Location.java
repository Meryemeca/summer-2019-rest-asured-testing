package com.automation.pojos;

import com.google.gson.annotations.SerializedName;

/**
 *
 *  {
 *             "location_id": 2000,
 *             "street_address": "40-5-12 Laogianggen",
 *             "postal_code": "190518",
 *             "city": "Beijing",
 *             "state_province": null,
 *             "country_id": "CN",
 *             "links": [
 *                 {
 *                     "rel": "self",
 *                     "href": "http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr/locations/2000"
 *                 }
 *             ]
 *         },
 *
 */

public class Location {

    @SerializedName("location_id")
    private Integer locationId;
    @SerializedName("street_address")
    private String streetAddress;
    @SerializedName("postal_code")
    private String postalCode;
    private  String city;
    @SerializedName("state_province")
    private String stateProvince;
    @SerializedName("country_id")
    private String countryId;

    public Location(){

    }
    public Location(Integer locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locationId='" + locationId + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countryId='" + countryId + '\'' +
                '}';
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }
}
