public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
  
    // Default Constructor
    public Student() {
    }
  
    // Parameterized Constructor
    public Student(int id, String name, int age, String course) {
      if (id < 0) throw new IllegalArgumentException("ID must be non-negative.");
      if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
      if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
      if (course == null || course.trim().isEmpty()) throw new IllegalArgumentException("Course cannot be null or empty.");
  
      this.id = id;
      this.name = name;
      this.age = age;
      this.course = course;
    }
  
    // Getters and Setters
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      if (id < 0) throw new IllegalArgumentException("ID must be non-negative.");
      this.id = id;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
      this.name = name;
    }
  
    public int getAge() {
      return age;
    }
  
    public void setAge(int age) {
      if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
      this.age = age;
    }
  
    public String getCourse() {
      return course;
    }
  
    public void setCourse(String course) {
      if (course == null || course.trim().isEmpty()) throw new IllegalArgumentException("Course cannot be null or empty.");
      this.course = course;
    }
  
    @Override
    public String toString() {
      return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Course=" + course + "]";
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Student student = (Student) obj;
      return id == student.id;
    }
  
    @Override
    public int hashCode() {
      return Integer.hashCode(id);
    }
  }
  