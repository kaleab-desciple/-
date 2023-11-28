package sms_updated;

    // class with int variable and Array of StudCourse objects
public class Courses {

    int rollNumber;

    // creating an instance Array of  class StudCourse
    StudCourse [] sc;    

    // course object constructor 
    public Courses(int rollNumber, StudCourse[] sc ){
        this.rollNumber=rollNumber;
        this.sc=sc;
    }
}
