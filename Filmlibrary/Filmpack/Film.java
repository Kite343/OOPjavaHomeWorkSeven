package Filmpack;

public class Film {
    String name;
    Genre genre;
    String director;
    FileExtention file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setFile(FileExtention file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return name + ',' + genre + ',' + director + ',' + file;
    }
}
