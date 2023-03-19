public class Student {

    private String name;
    private int studentNumber = 0;
    private int[] marks = {1,2,3,4,5,6};
    private boolean currentlyRegistered = false;

    public Student(String name, int studentNumber, int[] marks, boolean currentlyRegistered) {
        if (name.length() <= 30)
            this.name = name;
        else
            this.name = name.substring(0,30);
        this.studentNumber= studentNumber;
        this.marks = marks;
        this.currentlyRegistered = currentlyRegistered;
    }

    public float getAverageMark() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return marks.length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }


    public int setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
        if (studentNumber >= 10000000 && studentNumber < 19999999) {
            return studentNumber;
        }
        else
            return studentNumber;
    }

    public int[] getMarks() {
        return marks;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public boolean isCurrentlyRegistered() {
        return currentlyRegistered;
    }

    public void setCurrentlyRegistered(boolean currentlyRegistered) {
        this.currentlyRegistered = currentlyRegistered;
    }

    @Override
    public String toString() {
        String marksString = "";
        for (int i = 0; i <6; i++)
        {
            marksString += marks[i] + " ";
        }

        return "Student details :" +
                "name = " + name  +
                " studentNumber = " + studentNumber +
                " marks = " + marksString +
                "Is this student currently registered? = " + currentlyRegistered +
                '}';
    }
}

