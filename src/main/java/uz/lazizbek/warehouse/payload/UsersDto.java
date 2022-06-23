package uz.lazizbek.warehouse.payload;

import uz.lazizbek.warehouse.entity.Warehouse;

import java.util.List;
import java.util.Set;

public class UsersDto {
    private  String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String username;
    private List<Integer> warehouses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Integer> warehouses) {
        this.warehouses = warehouses;
    }
}
