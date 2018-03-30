/**
 * Project Name:ClassTest
 * File Name:QuestionInfo.java
 * Package Name:com.java.entity
 * Date:2018年3月28日下午3:40:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午3:40:10 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class QuestionInfo {
    private int questionId;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private int subject;

    private String answer;

    public QuestionInfo() {

    }

    public QuestionInfo(int questionId, String question, String optionA, String optionB, String optionC, String optionD,
            int subject, String answer) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.subject = subject;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
