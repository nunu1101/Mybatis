package com.ohgiraffers.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.remix.Template.getSqlSession;

public class EmployeeService {
    public List<EmployeeDTO> selectAllEmployee() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> employeeList = employeeMapper.selectAllEmployee();
        sqlSession.close();
        return employeeList;
    }
    public static EmployeeDTO selectOneEmployee(int empId) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeDTO employee = employeeMapper.selectOneEmployee(empId);
        sqlSession.close();
        return employee;
    }

    public boolean registEmployee(EmployeeDTO employee) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = employeeMapper.insertEmployee(employee);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true: false;
    }

    public boolean modifyEmployee(EmployeeDTO employee) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = employeeMapper.updateEmployee(employee);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true: false;
    }

    public boolean deleteEmployee(int empId) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = employeeMapper.deleteEmployee(empId);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true: false;
    }
}
