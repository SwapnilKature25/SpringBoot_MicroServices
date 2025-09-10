package com.it.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.Employee;
import com.it.repo.EmployeeRepository;
import com.opencsv.CSVReader;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    /**
     * Reads employee data from a CSV file and stores it into the MySQL database.
     * @param filePath Path of the CSV file
     */
    public void saveEmployeesFromCsv(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            List<Employee> employees = new ArrayList<>();

            // Skip header row
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                Employee emp = new Employee();
                emp.setEmpName(line[0]);
                emp.setEmpDesg(line[1]);
                emp.setEmpAddr(line[2]);
                employees.add(emp);
            }

            // Save all employees in one batch
            repo.saveAll(employees);
            System.out.println("✅ Employees saved successfully in MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
