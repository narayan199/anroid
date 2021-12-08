package com.example.databinding;

import android.renderscript.BaseObj;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class StudentData extends BaseObservable {
    private String student;
    private String grade;
    //constructor

    public StudentData(String student, String grade) {
        this.student = student;
        this.grade = grade;
    }
    //getter&setter

    @Bindable
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
        notifyPropertyChanged(BR.student);
    }
    @Bindable
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        notifyPropertyChanged(BR.grade);
    }
}
