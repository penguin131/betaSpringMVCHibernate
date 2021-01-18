package edu.school21.cinema.models;

import javax.persistence.*;

@Entity
@Table(name="t_film", schema="cinema")
public class Film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int filmId;
    @Column
    private String name;
    @Column
    private int year;
    @Column(name = "min_age")
    private int minAge;
    @Column
    private String description;
    @Column(name = "poster_mime")
    private String posterMime;
    @Transient
    private String imageLink;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int hallId) {
        this.filmId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterMime() {
        return posterMime;
    }

    public void setPosterMime(String posterMime) {
        this.posterMime = posterMime;
    }
}
