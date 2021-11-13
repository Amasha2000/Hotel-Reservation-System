package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Customer {
    private String name;
    private String nic;
    private String contact;
    private String email;
    private String address;
    private String payment;
    private String roomNumber;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private LocalTime arrivalTime;
    private LocalTime departureTime;

    public Customer() {
    }

    public Customer(String name, String nic, String contact, String email, String address,String payment,String roomNumber,LocalDate arrivalDate,LocalDate departureDate,LocalTime arrivalTime,LocalTime departureTime) {
        this.setName(name);
        this.setNic(nic);
        this.setContact(contact);
        this.setEmail(email);
        this.setAddress(address);
        this.setPayment(payment);
        this.setRoomNumber(roomNumber);
        this.setArrivalDate(arrivalDate);
        this.setDepartureDate(departureDate);
        this.setArrivalTime(arrivalTime);
        this.setDepartureTime(departureTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }


    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() { return departureTime; }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
}