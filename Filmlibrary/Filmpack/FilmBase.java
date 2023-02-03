package Filmpack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FilmBase {
    ArrayList<Film> recordfilms = new ArrayList<>();

    String name;

    public ArrayList<Film> getrecordfilms() {
        return recordfilms;
    }

    public void setrecordfilms(ArrayList<Film> record) {
        this.recordfilms = record;
    }

    public Film createFilm() {
        int a;
        Scanner input = new Scanner(System.in, "Cp866");
        FilmBuilder film = FilmBuilder.getInstance();
        System.out.println("Введите название: ");
        film.setname(input.nextLine());
        System.out.println("Введите фамилию режисера: ");
        film.setdirector(input.nextLine());
        System.out.println("Выберите жанр:\nКомедия - 1\nУжасы -2\nБоевик-3\nДрама-4\nДругое - любой символ");
        try {
            a = (input.nextInt());
            if (a == 1) {
                film.setgenre(Genre.comedy);
            } else if (a == 2) {
                film.setgenre(Genre.horror);
            } else if (a == 3) {
                film.setgenre(Genre.action);
            } else if (a == 4) {
                film.setgenre(Genre.drama);
            } else {
                film.setgenre(Genre.other);
            }
        } catch (InputMismatchException inputMismatchException) {
            film.setgenre(Genre.other);
        }
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println("Выберите формат файла:\nmkv - 1\nmp4 -2\navi-3\nДругое - любой символ");
        try {
            a = (in.nextInt());
            if (a == 1) {
                film.setfile(FileExtention.mkv);
            } else if (a == 2) {
                film.setfile(FileExtention.mp4);
            } else if (a == 3) {
                film.setfile(FileExtention.avi);
            } else {
                film.setfile(FileExtention.other);
            }
        } catch (InputMismatchException inputMismatchException) {
            film.setfile(FileExtention.other);
        }
        return film.build();
    }

    public void fillRecord(ArrayList<Film> record) {
        boolean flag = true;
                while (flag) {
            System.out.println("Вы хотите добавить новый фильм? 1 - Да, 2 - Нет");
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            if (a == 1) {
                record.add(createFilm());
            } else if (a == 2) {
                System.out.println("База фильмов сохранена");
                flag = false;
            } else {
                System.out.println("Введите 1 - Да  или 2 - Нет");
            }
        }
        setrecordfilms(record);
    }

//    public void findRecord(ArrayList<Film> record) {
//        System.out.println("Введите название фильма");
//        Scanner input = new Scanner(System.in);
//        String a = input.nextLine();
//        int index = -1;
//        for (Film x : record
//        ) {
//            if (x.getName().contains(a)) {
//                index = record.indexOf(x);
//            }
//            if (index == -1) {
//                System.out.println("Такого фильма нет");
//            } else {
//                System.out.println("Индекс вашего фильма в базе: " + index + "\n Полное название фильма: " + record.get(index).getName());
//            }
//        }
//    }
//

    public void outputToTxtFile(String filename, ArrayList<Film> record) throws IOException {
        filename = filename + ".txt";
        FileWriter fileWriter = new FileWriter(filename);

        for (Film x : record) {
            fileWriter.write(x.toString());
            fileWriter.write("\n");
        }
        fileWriter.flush();
    }
    public ArrayList<Film> inputFile(String filename) throws IOException {
        String[] parsing;
        ArrayList<Film> output = new ArrayList<>();
        java.io.File file = new File(filename +".txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            parsing = scanner.nextLine().split(",");

            Film film= new Film();
            film.setName(parsing[0]);

            film.setGenre(Genre.valueOf(parsing[1]));

            film.setDirector(parsing [2]);

            film.setFile(FileExtention.valueOf(parsing [3]));

            output.add (film);
        }
        return output;
    }
}