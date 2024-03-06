package com.br.collectioncomparison.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.br.collectioncomparison.model.domain.Employee;
import com.br.collectioncomparison.model.service.EmployeeFileReader;
import com.br.collectioncomparison.patterns.factory.ConnectionFactory;

public class JDBCTest {
	public static void main(String[] args) {

		Connection conn = ConnectionFactory.getConnection();

		PreparedStatement ps = null;

		try(FileWriter fr = new FileWriter(new File("files/db.sql"), true);
			BufferedWriter bw = new BufferedWriter(fr)) {

			Employee[] employees = EmployeeFileReader.read("files/MOCK_DATA1000000.csv");

			ps = conn.prepareStatement("INSERT INTO Employee (id, nome, data_nasc, department, company, salary) VALUES (?, ?, ?, ?, ?, ?)");

			int i = 0;
			for(Employee employee: employees) {
				//String line = employee.toString();
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setDate(3, new java.sql.Date(employee.getDateOfBonth().getTime()));
				ps.setString(4, employee.getDepartament());
				ps.setString(5, employee.getCompany());
				ps.setDouble(6, employee.getSalary());
				ps.executeUpdate();
				//bw.write(line);
				//bw.write(",\n");

				if(i++ == 2) break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(ps);
		}


	}
}
