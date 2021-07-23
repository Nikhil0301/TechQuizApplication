/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

/**
 *
 * @author hp
 */
public class Question {
    private String examId;
    private int qno;
    private String language;
    private String Answer1,Answer2,Answer3,Answer4;
    private String correctAnswer;
    private String question;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Question other = (Question) obj;
        if (this.examId.equals(other.examId)==false) {
            return false;
        }
        if (this.qno != other.qno) {
            return false;
        }
        if (this.question.equals(other.question)==false) {
            return false;
        }
        if (this.Answer1.equals(other.Answer1)==false) {
            return false;
        }
        if (this.Answer2.equals(other.Answer2)==false) {
            return false;
        }
        if (this.Answer3.equals(other.Answer3)==false) {
            return false;
        }
        if (this.Answer4.equals(other.Answer4)==false) {
            return false;
        }
        if (this.correctAnswer.equals(other.correctAnswer)==false) {
            return false;
        }
        return true;
    }

    public Question(String examId,String language,int qno, String question,String Answer1, String Answer2, String Answer3, String Answer4, String correctAnswer) {
        this.examId = examId;
        this.qno = qno;
        this.language = language;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.Answer4 = Answer4;
        this.correctAnswer = correctAnswer;
        this.question = question;
        //who is the father of c language ?
        //Bjarne
        //james A Gosling
        //Dennis ritchie
        //Dr. E.F. Codd
        
        //C programs are converted into machine language with the help of____ ?
        //An editor
        //A compiler
        //An Operating system
        //None of these
    }

    public Question() {
        
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String answer1) {
        this.Answer1 = Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        this.Answer2 = Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String answer3) {
        this.Answer3 = Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String answer4) {
        this.Answer4 = Answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "examId=" + examId + ", qno=" + qno + ", language=" + language + ", Answer1=" + Answer1 + ", Answer2=" + Answer2 + ", Answer3=" + Answer3 + ", Answer4=" + Answer4 + ", correctAnswer=" + correctAnswer + ", question=" + question + '}';
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
