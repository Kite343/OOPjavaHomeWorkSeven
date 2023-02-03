package Filmpack;

public class FilmBuilder {
    private static FilmBuilder instance;
    Film obj;

    private FilmBuilder() {
    }


    public static FilmBuilder getInstance() {
        if (instance == null)
            instance = new FilmBuilder();
            instance.obj = new Film();

        return instance;
    }

    public void setname(String a) {
        obj.name = a;
    }

    public void setdirector(String a) {
        obj.director = a;
    }
    public void setgenre(Genre a) {
        obj.genre = a;
    }
    public void setfile (FileExtention a) {
     obj.file=a;
    }
    public Film build() {
        return obj;

    }

}
