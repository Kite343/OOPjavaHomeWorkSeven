package Personpack;

public class PersonBuilder {
    private static PersonBuilder instance;
    Person obj;

    private PersonBuilder() {
    }


    public static PersonBuilder getInstance() {
        if (instance == null)
            instance = new PersonBuilder();
            instance.obj = new Person();

        return instance;
    }

    public void setname(String a) {
        obj.name = a;
    }

    public void setsurname (String a) {
        obj.surname = a;
    }
    public void setphone(String a) {
        obj.phoneNumber = a;
    }
    public void setrole (Role a){
        obj.role = a;
    }
    public Person build() {
        return obj;

    }

}

