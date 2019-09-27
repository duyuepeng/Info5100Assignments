import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    public Course(int courseId) {
        this.setCourseId(courseId);
        this.setMaxCapacity(50);
        this.studentIds = new int[0];
    }

    public Course(int courseId, int professorId) {
        this(courseId);
        this.setProfessorId(professorId);
    }

    public Course(int courseId, int professorId, int credits) {
        this(courseId, professorId);
        this.setCredits(credits);
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId <= 0) {
            throw new IllegalArgumentException("courseId - should not be negative or 0.");
        }
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.length() < 10 || courseName.length() > 60) {
            throw new IllegalArgumentException("courseName- should be a string with minimum length 10 and maximum 60.");
        }
        this.courseName = courseName;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity < 10 || maxCapacity > 100) {
            throw new IllegalArgumentException("maxCapacity - should not be less than 10 greater than 100.");
        }
        this.maxCapacity = maxCapacity;
    }

    public int getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(int professorId) {
        if (professorId < 100000 || professorId > 999999) {
            throw new IllegalArgumentException("professorId - should be a six digit integer.");
        }
        this.professorId = professorId;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        if (credits <= 0 || credits > 9) {
            throw new IllegalArgumentException("credits - should be a single digit but greater than 0.");
        }
        this.credits = credits;
    }

    public int[] getStudentIds() {
        return this.studentIds;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    public static int[] removeDuplicates(int[] studentIds) {
        Set<Integer> set = new HashSet<>();
        for (int id : studentIds) {
            set.add(id);
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

    public void registerStudent(int studentID) {
        int currentNum = this.studentIds.length + 1;
        if (currentNum > this.getMaxCapacity()) {
            this.setStudentIds(removeDuplicates(this.getStudentIds()));
            currentNum = this.studentIds.length + 1;
        }
        if (currentNum > this.getMaxCapacity()) {
            throw new RuntimeException("Course is full.");
        }
        int[] newArray = new int[currentNum];
        System.arraycopy(this.studentIds, 0, newArray, 0, this.studentIds.length);
        newArray[this.studentIds.length] = studentID;
        this.studentIds = newArray;
    }

    public static int groupsOfStudents(int[] studentIds) {
        int sum = 0;
        for (int i = 0; i < studentIds.length - 1; i++) {
            for (int j = i + 1; j < studentIds.length; j++) {
                if ((studentIds[i] + studentIds[j]) % 2 == 0)
                    sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Course course = new Course(1, 100000, 3);
        course.setMaxCapacity(10);
        for (int i = 0; i < 8; i++) {
            course.registerStudent(i);
            System.out.println(Arrays.toString(course.getStudentIds()));
        }
        course.registerStudent(6);
        course.registerStudent(7);
        System.out.println(Arrays.toString(course.getStudentIds()));

        try {
            for (int i = 8; i < 11; i++) {
                course.registerStudent(i);
                System.out.println(Arrays.toString(course.getStudentIds()));
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        try {
            course.setCourseId(2);
            course.setCourseId(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("CourseId: " + course.getCourseId());
        }

        try {
            course.setCourseName("TestCourseName");
            course.setCourseName("a");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("CourseName: " + course.getCourseName());
        }

        try {
            course.setMaxCapacity(100);
            course.setMaxCapacity(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("MaxCapacity: " + course.getMaxCapacity());
        }

        try {
            course.setProfessorId(999999);
            course.setProfessorId(1000000);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("ProfessorId: " + course.getProfessorId());
        }

        try {
            course.setCredits(1);
            course.setCredits(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Credits: "+course.getCredits());
        }

        System.out.println(groupsOfStudents(course.getStudentIds()));

    }

}
