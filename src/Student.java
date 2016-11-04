/*
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 */

import java.io.Serializable;

public class Student implements Serializable{
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    private static final String FILE_NAME = "MyGame.ser";

    public Student(){
        super();
        faveSubject = new Course();
    }

    public Student(String studentNumber, String firstName, char middleInitial,
                   String lastName, String course, int yearLevel,String crushName,String courseCode,String courseDes) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject.courseCode = courseCode;
        this.faveSubject.courseDescription = courseDes;
    }

    public void setCourseCode(String courseCode){
        faveSubject.courseCode = courseCode;
    }
    public void setCourseDes(String courseCode){
        faveSubject.courseDescription = courseCode;
    }
    public String getCourseCode(){
        return faveSubject.getCourseCode();
    }
    public String getCourseDes(){
        return faveSubject.getCourseDescription();
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public char getMiddleInitial() {
        return middleInitial;
    }
    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCrushName() {
        return crushName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getYearLevel() {
        return yearLevel;
    }
    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
    public String toString(){
        return "Student Number: "+getStudentNumber()+
                "\nName: "+getLastName()+", " + getFirstName() + " "+ getMiddleInitial()+"."
                +"\nProgram: "+getCourse()
                +"\nYear Level: " +getYearLevel()
                +"\nCourse Code: "+faveSubject.getCourseCode()
                +"\nCourse Description: " +faveSubject.getCourseDescription()
                + "\nCrush's Name: " +getCrushName()+"\n";
    }
    public String toString(boolean a){
        return studentNumber + '\n' + firstName + '\n' + middleInitial + '\n' + lastName + '\n' + course + '\n' + yearLevel+ '\n' + crushName;
    }
}