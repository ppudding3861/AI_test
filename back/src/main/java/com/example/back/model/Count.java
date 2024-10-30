package com.example.back.model;

import jakarta.persistence.*;

@Entity
@Table(name = "count")
public class Count {

    @Id
    @Column(name = "count_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countId;

    @Column(name = "count_num")
    private int countNum;

    public Count() {
    }

    public Count(int countId, int countNum) {
        this.countId = countId;
        this.countNum = countNum;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    @Override
    public String toString() {
        return "Count{" +
                "countId=" + countId +
                ", countNum=" + countNum +
                '}';
    }
}
