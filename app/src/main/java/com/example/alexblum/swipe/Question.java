package com.example.alexblum.swipe;

/**
 * Created by Alexander on 12/15/2016.
 */

public class Question {
    public String question;
    public Integer id;
    public Integer score;

    public Question (){

    }

    public Question (Integer id, String question, Integer score) {
        this.id = id;
        this.question = question;
        this.score = score;
    }

}
