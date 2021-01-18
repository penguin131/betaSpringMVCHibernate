package edu.school21.cinema.models;

import javax.persistence.*;

@Entity
@Table(name="t_session", schema="cinema")
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sessionId;
    @ManyToOne
    @JoinColumn(name="film")
    private Film film;
    @ManyToOne
    @JoinColumn(name="hall")
    private Hall hall;
    private Float cost;
    private long time;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
