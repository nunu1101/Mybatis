package com.ohgiraffers.section01.remix;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();
    EmployeeDTO selectOneEmployee(int empId);
    int insertEmployee(EmployeeDTO employee);
    int updateEmployee(EmployeeDTO employee);
    int deleteEmployee(int empId);
}
