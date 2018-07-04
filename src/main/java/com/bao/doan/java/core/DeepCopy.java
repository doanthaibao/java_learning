package com.bao.doan.java.core;
 class CourseEx implements Cloneable
{
    String subject1;
 
    String subject2;
 
    String subject3;
 
    public CourseEx(String sub1, String sub2, String sub3)
    {
        this.subject1 = sub1;
 
        this.subject2 = sub2;
 
        this.subject3 = sub3;
    }
 
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
 
class StudentEx implements Cloneable
{
    int id;
 
    String name;
 
    CourseEx course;
 
    public StudentEx(int id, String name, CourseEx course)
    {
        this.id = id;
 
        this.name = name;
 
        this.course = course;
    }
 
    //Overriding clone() method to create a deep copy of an object.
 
    protected Object clone() throws CloneNotSupportedException
    {
        StudentEx student = (StudentEx) super.clone();
 
        student.course = (CourseEx) course.clone();
 
        return student;
    }
}
public class DeepCopy {
	 public static void main(String[] args)
	    {
	        CourseEx science = new CourseEx("Physics", "Chemistry", "Biology");
	 
	        StudentEx student1 = new StudentEx(111, "John", science);
	 
	        StudentEx student2 = null;
	 
	        try
	        {
	            //Creating a clone of student1 and assigning it to student2
	 
	            student2 = (StudentEx) student1.clone();
	        }
	        catch (CloneNotSupportedException e)
	        {
	            e.printStackTrace();
	        }
	 
	        //Printing the subject3 of 'student1'
	 
	        System.out.println(student1.course.subject3);         //Output : Biology
	 
	        //Changing the subject3 of 'student2'
	 
	        student2.course.subject3 = "Maths";
	 
	        //This change will not be reflected in original student 'student1'
	 
	        System.out.println(student1.course.subject3);       //Output : Biology
	    }
}
