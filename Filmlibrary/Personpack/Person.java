package Personpack;

public class Person {
    String name;
    String surname;
    String phoneNumber;
    Role role;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return name + ',' + surname + ',' + phoneNumber + ',' + role;
    }
}
