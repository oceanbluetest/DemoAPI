package tests01.pojo.dummyAPI;

public class Employee2 {
    String status;
    EmployeeData2 data;
    String message;

    public Employee2(){}

    public Employee2(String status, EmployeeData2 data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeData2 getData() {
        return data;
    }

    public void setData(EmployeeData2 data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "status = " + status + '\'' +
                "\ndata:" + data +
                "\nmessage = " + message;
    }

    public class EmployeeData2 {
        int id;
        String employee_name;
        int employee_salary;
        int employee_age;
        String profile_image;

        public EmployeeData2(){}

        public EmployeeData2(int id, String employee_name, int employee_salary, int employee_age, String profile_image) {
            this.id = id;
            this.employee_name = employee_name;
            this.employee_salary = employee_salary;
            this.employee_age = employee_age;
            this.profile_image = profile_image;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public int getEmployee_salary() {
            return employee_salary;
        }

        public void setEmployee_salary(int employee_salary) {
            this.employee_salary = employee_salary;
        }

        public int getEmployee_age() {
            return employee_age;
        }

        public void setEmployee_age(int employee_age) {
            this.employee_age = employee_age;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        @Override
        public String toString() {
            return "\n\t id=" + id +
                    "\n\t employee_name = " + employee_name + '\'' +
                    "\n\t employee_salary = " + employee_salary +
                    "\n\t employee_age = " + employee_age +
                    "\n\t profile_image = " + profile_image;
        }
    }
}
