package model;

import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Administrator on 17.04.2015.
 */
@Entity
@Table(name = "abscent", schema = "", catalog = "students")
public class AbscentEntity {
    private int id;
    private int studentId;
    private Date date;
    private StudentEntity studentByStudentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbscentEntity that = (AbscentEntity) o;

        if (id != that.id) return false;
        if (studentId != that.studentId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (int) studentId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    public StudentEntity getStudentByStudentId(){
        return studentByStudentId;
    }
    public void setStudentByStudentId(StudentEntity studentByStudentId){
        this.studentByStudentId = studentByStudentId;
    }
}
