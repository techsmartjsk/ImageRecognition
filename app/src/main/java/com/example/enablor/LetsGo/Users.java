package com.example.enablor.LetsGo;

public class Users {
    String userid;
    String travel;
    String totalbill;
    String food;
    String persons;


    public Users(String userid, String travel, String totalbill, String food, String persons) {
        this.userid = userid;
        this.travel = travel;
        this.totalbill = totalbill;
        this.food = food;
        this.persons = persons;
    }

    public String getUserid() {
        return userid;
    }

    public String getTravel() {
        return travel;
    }

    public String getTotalbill() {
        return String.valueOf(Integer.parseInt(travel) + Integer.parseInt(food));
    }

    public String getFood() {
        return food;
    }

    public String getPersons() {
        return persons;
    }
}
