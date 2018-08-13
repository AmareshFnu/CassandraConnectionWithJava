package com.cassandra.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */

// CREATE KEYSPACE cqltest WITH replication = {'class': 'SimpleStrategy',
// 'replication_factor': '5'}

public class CassandraClient {
	public static void main(String[] args) {

		String ipAddress = "127.0.0.1";
		String keySpace = "CQLTest";
		int PortNumber = 9042;

		Cluster cluster;
		Session session;

		cluster = Cluster.builder().addContactPoint(ipAddress).withPort(PortNumber).build();

		session = cluster.connect(keySpace);

		session.execute("insert into employee (empID,empname,designation) values (6,'rahul1','lead1')");

		ResultSet resultSet = session.execute("select *from employee");

		for (Row row : resultSet) {

			System.out.println(
					row.getInt("empID") + "  " + row.getString("empname") + " " + row.getString("designation"));

		}

	}
}
