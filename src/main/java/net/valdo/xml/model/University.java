package net.valdo.xml.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
 
import net.valdo.xml.model.Student;

@XmlRootElement(name = "University")
@XmlType(propOrder = { "name", "address", "students" })

public class University {
	
	List<Student> students;
	 
    private String name;
 
    private String address;
    
    Student s1 = new Student();
    
     
    @XmlElementWrapper(name = "Students")
    @XmlElement(name = "Student")
    
    public List<Student> getStudents() {
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
}
