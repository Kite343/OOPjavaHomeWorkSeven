package Controller;

import Filmpack.Film;
import Filmpack.FilmBase;
import Rentpack.RentFilm;
import Personpack.Person;
import Personpack.PersonBase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Person admin;
    ArrayList<Film> fb;
    ArrayList<Person> pb;
    ArrayList<RentFilm> rf;
    FilmBase filmbase;
    PersonBase personbase;
    RentFilm rentFilm;

    public Controller() {
        filmbase = new FilmBase();
        personbase = new PersonBase();
        rentFilm = new RentFilm();
    }

    public void start () throws IOException {
        
        fb = filmbase.inputFile("База фильмов");
        pb = personbase.inputFile("База людей");
        rf =rentFilm.inputFile("База записей", pb);
        admin = personbase.Worker(pb);
        if (admin != null) {

            int a;
            System.out.println("""
                    Выберите вариант:
                    1 - Дополнить базу фильмов
                    2 - Дополнить базу людей
                    3 - Дополнить базу записей об аренде фильмов""");
            Scanner input = new Scanner(System.in, "Cp866");
            a = input.nextInt();
            if (a == 1) {
                filmbase.fillRecord(fb);
                filmbase.outputToTxtFile("База фильмов", filmbase.getrecordfilms());
            }
            if (a == 2) {
                personbase.fillRecord(pb);
                personbase.outputToTxtFile("База людей", personbase.getRecordpersons());
            }
            if (a == 3) {
                rentFilm.fillRecord(rf,pb, fb, admin);
                rentFilm.outputToTxtFile("База записей", rentFilm.getRentFilmArrayList());
            }
        }
        else{
            System.out.println("Пользователя с таким именем не существует");
        }
    }
}
