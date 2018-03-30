/**
 * Project Name:dt59_dao
 * File Name:Info.java
 * Package Name:com.entity
 * Date:2018年3月28日下午2:44:28
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.entity;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午2:44:28 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
/*
 * 实体类QuestionInfo，根据业务提供需要的构造方法和setter/getter方法。
 */
public class QuestionInfo {
    private int questionID;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private int subject;

    private String answer;

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}