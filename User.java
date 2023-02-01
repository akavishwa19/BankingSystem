public class User {
    private String name;
    private int age;
    private String address;
    private String accName;
    private String password;
    private double balance;
    private int pin;


    public User(){

    }
    public User(String name, int age, String address, String accName, String password, double balance, int pin) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.accName = accName;
        this.password = password;
        this.balance=5000;
        this.pin=pin;
    }
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", accName='" + accName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
