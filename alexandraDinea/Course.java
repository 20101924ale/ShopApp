import java.util.Arrays;

public class Course {

    private Student[] students;

    private int total = 0;

    public Course(int numberStudents) {
        students = new Student[numberStudents];
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getTotal() {
        return total;
    }

    public boolean add(Student student) {
        students[total] = student;
        total++;
        return true;
    }

    public double averageOfStudentsAvgMark() {
        if (!isEmpty()) {
            double totalMarks = 0;
            for (int i = 0; i < total; i++) {
                totalMarks += students[i].getAverageMark();
            }
            return totalMarks / total;
        } else {
            return -1;
        }
    }

    public Student deRegisterStudent(int indextoDeRegister){
        if (indextoDeRegister < 0 || indextoDeRegister >= total)
            return null;
        else {
            students[indextoDeRegister].setCurrentlyRegistered(false);
            return students[indextoDeRegister];
        }
    }


    public boolean isEmpty() {
        return total == 0;
    }

    public String listCurrentStudents() {
        if (isEmpty()) {
            return "No students enrolled in course";
        } else {
            String listOfStudents = "";
            for (int i = 0; i < total; i++) {
                if (students[i].isCurrentlyRegistered())
                    listOfStudents += i + ": " + students[i] + "\n";
            }
            if (listOfStudents.equals("")) {
                return "No students are currently registered";
            } else {
                return listOfStudents;
            }
        }
    }

    public String listOfStudentWithAvgMark() {
        String listOfStudentsAvgMark = "";
        for (int i = 0; i < total; i++) {
            listOfStudentsAvgMark += i + ": " + students[i] + "\n";
        }
        return listOfStudentsAvgMark;
    }

    public String listStudents() {
        if (isEmpty()) {
            return "No Students available";
        } else {
            String listOfStudents = "";
            for (int i = 0; i < total; i++) {
                listOfStudents += i + ": " + students[i] + "\n";
            }
            return listOfStudents;
        }
    }

    public String listStudentsAboveAverageMark(double marks) {
        if (isEmpty()) {
            return "No Students in this Course";
        } else {
            String list = "";
            for (int i = 0; i < students.length; i++) {
                if (students[i].getAverageMark() > marks) {
                    list += (i + 1) + " :" + students[i].getName() + students[i].getAverageMark() + "\n";
                }
            }
            return list;
        }
    }

    public Student studentWithHighestAverageMark() {
        if (isEmpty()) {
            return null;
        } else {
            double highestGrade = students[0].getAverageMark();
            Student highestStudent = students[0];
            for (int i = 0; i < students.length; i++) {
                if (students[i].getAverageMark() > highestGrade) {
                    highestGrade = students[i].getAverageMark();
                    highestStudent = students[i];
                }
            }
            return highestStudent;
        }
    }
    public Student studentWithLowestAverageMark() {
        if (isEmpty()) {
            return null;
        } else {
            double lowestGrade = students[0].getAverageMark();
            Student lowestStudent = students[0];
            for (int i = 0; i > students.length; i++) {
                if (students[i].getAverageMark() > lowestGrade) {
                    lowestGrade = students[i].getAverageMark();
                    lowestStudent = students[i];
                }
            }
            return lowestStudent;
        }
    }

    @Override
    public String toString() {

        return "Course{" +
                "students=" + Arrays.toString(students) +
                "total=" + total +
                '}';
    }
}



