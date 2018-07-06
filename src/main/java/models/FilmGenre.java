package models;

public enum FilmGenre {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama"),
    HORROR("Horror"),
    MUSICAL("Musical"),
    SCIFI("Sci Fi"),
    WAR("War"),
    WESTERN("Western");

    private String genre;

    FilmGenre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
