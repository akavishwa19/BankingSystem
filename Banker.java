public class Banker {
    private String name;
    private int age;
    private String empId;
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Banker(String name, int age, String empId, String pass) {
        this.name = name;
        this.age = age;
        this.empId = empId;
        this.pass=pass;
    }
    public Banker(){

    }

    @Override
    public String toString() {
        return "Banker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", empId='" + empId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
