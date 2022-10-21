package item13.shallow_copy;

public class Employee implements Cloneable{
    private String name;
    private Integer age;
    private EmployeeAddress empAddress;

    public Employee(String name, Integer age, EmployeeAddress empAddress) {
        this.name = name;
        this.age = age;
        this.empAddress = empAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeAddress getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(EmployeeAddress empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee empObj = (Employee) obj;
        return this.age == empObj.age
                && this.name.equalsIgnoreCase(empObj.name);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", empAddress=" + empAddress +
                '}';
    }
}
