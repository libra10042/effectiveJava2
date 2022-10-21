package item13.deep_copy;

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
    //Code for CloningInJava.java, Employee.java and EmployeeAddress.java remain the same
    //Only the code in Employee.clone() method changes to implement deep copying
    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee empClone = (Employee) super.clone();
        EmployeeAddress empAddressClone = new EmployeeAddress(this.empAddress.getHouseNo(),
                this.empAddress.getStreet(),
                this.empAddress.getCity());
        empClone.setEmpAddress(empAddressClone);
        return empClone;
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
