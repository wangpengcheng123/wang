/**
 * Project Name:wuzhen
 * File Name:QuestionInfo.java
 * Package Name:question_info
 * Date:2018年3月28日下午4:02:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package question_info;



/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:02:22 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class QuestionInfo {

//       试题编号(QuestionId)
//       题干(Question)
//       选项A (optionA)
//       选项B (optionB)
//       选项C (optionC)
//       选项D (optionD)
//       科目(subject)
//       正确答案(answer)
    private int questionId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int subject;
    private String answer;
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

