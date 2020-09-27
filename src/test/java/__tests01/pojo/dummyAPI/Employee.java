package __tests01.pojo.dummyAPI;

public class Employee {
    String status;
    EmployeeData data;
    String message;

    public Employee(){}

    public Employee(String status, EmployeeData data, String message) {
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

    public EmployeeData getData() {
        return data;
    }

    public void setData(EmployeeData data) {
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
}
