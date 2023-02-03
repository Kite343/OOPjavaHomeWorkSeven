package Rentpack;

import Filmpack.Film;
import Personpack.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class RentFilm {
    String phonenumber;
    Person serviceAdmin;
    String rentedFilm;

    ArrayList <RentFilm> rentFilmArrayList = new ArrayList<>();

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    public void setServiceAdmin(Person serviceAdmin) {
        this.serviceAdmin = serviceAdmin;
    }

    public String getRentedFilm() {
        return rentedFilm;
    }

    public void setRentedFilm(String rentedFilm) {
        this.rentedFilm = rentedFilm;
    }

    public ArrayList<RentFilm> getRentFilmArrayList() {
        return rentFilmArrayList;
    }

    public void setRentFilmArrayList(ArrayList<RentFilm> rentFilmArrayList) {
        this.rentFilmArrayList = rentFilmArrayList;
    }

    public RentFilm createRentFilm(ArrayList <Person> pb, ArrayList <Film> fb, Person admin) {
        RentFilm rentFilm = new RentFilm();
        String a;
        String b;
        System.out.println("Введите номер телефона арендатора: ");
        Scanner input = new Scanner(System.in, "Cp866");
        a = input.nextLine();
        for (Person person : pb) {
            if (person.getPhoneNumber().contains(a)) {
                rentFilm.setPhonenumber(person.getPhoneNumber());
            }
        }
        System.out.println("Введите название фильма: ");
        b = input.nextLine();
        for (Film film : fb) {
            if (film.getName().contains(b)) {
                rentFilm.setRentedFilm(film.getName());
            }
        }
        if ((rentFilm.getPhonenumber() == null) || (rentFilm.getRentedFilm()==null)){
            System.out.println("Запись пустая");
        }else {
            rentFilm.setServiceAdmin(admin);
        }
        return rentFilm;
    }

    public void fillRecord(ArrayList<RentFilm> record,ArrayList <Person> pb, ArrayList <Film> fb, Person admin) {
        boolean flag = true;
                while (flag) {
            System.out.println("Вы хотите добавить новую запись об аренде фильма? 1 - Да, 2 - Нет");
            Scanner input = new Scanner(System.in, "Cp866");
            int a = input.nextInt();
            if (a == 1) {
                record.add(createRentFilm(pb,fb,admin));
            } else if (a == 2) {
                System.out.println("База записей сохранена");
                flag = false;
            } else {
                System.out.println("Введите 1 - Да  или 2 - Нет");
            }
        }
        setRentFilmArrayList(record);
    }
    public void outputToTxtFile(String filename, ArrayList<RentFilm> record) throws IOException {
        filename = filename + ".txt";
        FileWriter fileWriter = new FileWriter(filename);

        for (RentFilm x : record) {
            fileWriter.write(x.toString());
            fileWriter.write("\n");
        }
        fileWriter.flush();
    }
    public ArrayList<RentFilm>  inputFile(String filename, ArrayList <Person> pb) throws IOException {
        String[] parsing;
        ArrayList<RentFilm> output = new ArrayList<>();
        java.io.File file = new File(filename +".txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            parsing = scanner.nextLine().split(",");

            RentFilm rentFilm = new RentFilm();
            rentFilm.setPhonenumber(parsing[0]);

            rentFilm.setRentedFilm(parsing[1]);

            for (Person x : pb
            ) {
                if (x.getName().contains(parsing[2])) {
                    rentFilm.setServiceAdmin(x);
                }
            }

            output.add(rentFilm);

        }
        return output;
    }
    @Override
    public String toString() {
        return phonenumber + ','  + rentedFilm+','+ serviceAdmin.getName();
    }
}
