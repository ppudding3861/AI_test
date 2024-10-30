package com.example.back.model;

public class CountDTO {

    private Integer countId;
    private int countNum;

    public CountDTO() {
    }

    public CountDTO(Integer countId, int countNum) {
        this.countId = countId;
        this.countNum = countNum;
    }

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
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
        return "CountDTO{" +
                "countId=" + countId +
                ", countNum=" + countNum +
                '}';
    }
}
