package test0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    abstract class Employee {
        private String name;
        private String phone;
        private String email;

        public Employee(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public abstract String toString();
    }

    class Faculty extends Employee {
        private String level;
        private String department;
        private double salary;

        public Faculty(String name, String phone, String email, String level, String department, double salary) {
            super(name, phone, email);
            this.level = level;
            this.department = department;
            this.salary = salary;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Faculty,%s,%s,%s,%s,%.2f,%s",
                    getName(), level, department, salary, getPhone(), getEmail());
        }
    }

    class Staff extends Employee {
        private String level;
        private String department;
        private double salary;

        public Staff(String name, String phone, String email, String level, String department, double salary) {
            super(name, phone, email);
            this.level = level;
            this.department = department;
            this.salary = salary;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Staff,%s,%s,%s,%.2f,%s,%s",
                    getName(), level, department, salary, getPhone(), getEmail());
        }
    }


    class EmployeeInfoManager {
        private static final String FILE_NAME = "employee_data.txt";

        public void writeToFile(List<Employee> employees) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Employee employee : employees) {
                    writer.write(employee.toString());
                    writer.newLine();
                }
                System.out.println("员工数据已成功写入文件：" + FILE_NAME);
            } catch (IOException e) {
                System.out.println("写入文件时发生错误：" + e.getMessage());
            }
        }

        public List<Employee> readFromFile() {
            List<Employee> employees = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 6) {
                        String type = parts[0];
                        String name = parts[1];
                        String level = parts[2];
                        String department = parts[3];
                        double salary = Double.parseDouble(parts[4]);
                        String phone = parts[5];
                        String email = parts[6];

                        if (type.equals("Faculty")) {
                            employees.add(new Faculty(name, phone, email, level, department, salary));
                        } else if (type.equals("Staff")) {
                            employees.add(new Staff(name, phone, email, level, department, salary));
                        }
                    }
                }
                System.out.println("已从文件：" + FILE_NAME + " 成功读取员工数据");
            } catch (IOException e) {
                System.out.println("读取文件时发生错误：" + e.getMessage());
            }
            return employees;
        }

        public void calculateSalaryStatistics(List<Employee> employees) {
            double totalFacultySalary = 0;
            int facultyCount = 0;
            double totalStaffSalary = 0;
            int staffCount = 0;
            for (Employee employee : employees) {
                if (employee instanceof Faculty) {
                    Faculty faculty = (Faculty) employee;
                    totalFacultySalary += faculty.getSalary();
                    facultyCount++;
                } else if (employee instanceof Staff) {
                    Staff staff = (Staff) employee;
                    totalStaffSalary += staff.getSalary();
                    staffCount++;
                }
            }
            System.out.println("\n=== 工资统计 ===");
            if (facultyCount > 0) {
                System.out.printf("教员总工资：%.2f 元，平均工资：%.2f 元\n",
                        totalFacultySalary, totalFacultySalary / facultyCount);
            } else {
                System.out.println("没有教员数据");
            }

            if (staffCount > 0) {
                System.out.printf("职员总工资：%.2f 元，平均工资：%.2f 元\n",
                        totalStaffSalary, totalStaffSalary / staffCount);
            } else {
                System.out.println("没有职员数据");
            }
        }
    }
}
