package com.automation.pojos;

public class Company {

    private int companyId;
    private Address address;
    private  String companyName;
    private String title;
    private String startDate;


    public int getCompanyId() {
        return companyId;
    }

    public Company(Address address, String companyName, String title, String startDate) {
        this.address = address;
        this.companyName = companyName;
        this.title = title;
        this.startDate = startDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "address=" + address +
                ", companyName='" + companyName + '\'' +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company() {
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }


}
