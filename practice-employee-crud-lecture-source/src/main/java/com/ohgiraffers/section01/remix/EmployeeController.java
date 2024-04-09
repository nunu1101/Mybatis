package com.ohgiraffers.section01.remix;

import java.util.List;
import java.util.Map;

public class EmployeeController {

    private final PrintResult printResult;
    private final EmployeeService employeeService;

    public EmployeeController() {
        printResult = new PrintResult();
        employeeService = new EmployeeService();
    }

    public void selectAllEmployee() {

        List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();
        if (employeeList != null) {
            printResult.printEmployeeList(employeeList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectOneEmployee(Map<String, String> parameter) {

        int empId = Integer.parseInt(parameter.get("empId"));

        EmployeeDTO employee = EmployeeService.selectOneEmployee(empId);

        if (employee != null) {
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registEmployee(Map<String, String> parameter) {

        String empName = parameter.get("empName");
        String empNo = parameter.get("empNo");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if (employeeService.registEmployee(employee)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyEmployee(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));
        String empName = parameter.get("empName");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if (employeeService.modifyEmployee(employee)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteEmployee(Map<String, String> parameter) {
        int empId = Integer.parseInt(parameter.get("empId"));

        if (employeeService.deleteEmployee(empId)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
