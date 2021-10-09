package Bai7;

import java.util.Arrays;

public class Teaching {
    public  Teacher teacher;
    public  Subject[] subjects;
    public  int[] quantity;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "Teaching{" +"Teacher=" + teacher +
                ", Subject=" + Arrays.toString(subjects) +
                ", Quantity=" + Arrays.toString(quantity) +
                "}";
    }


    public Teaching() {
    }

    public Teaching(Teacher teacher, Subject[] subjects, int []quantity) {
        this.teacher=teacher;
        this.subjects=subjects;
        this.quantity=quantity;
    }


}
