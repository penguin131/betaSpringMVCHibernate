package edu.school21.cinema.models;

import javax.persistence.*;

@Entity
@Table(name="t_hall", schema="cinema")
public class Hall {
    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int hallId;
    @Column(name = "number")
    private int number;
    @Column(name = "seats_count")
    private int seatsCount;

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }
}
