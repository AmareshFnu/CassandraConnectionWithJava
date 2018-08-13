package com.cassandra.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class TestCassandraConnection {
	
	
	public TestCassandraConnection(String cassandraHost, int cassandraPort, String keyspaceName) {
	    String m_cassandraHost = cassandraHost;
	    int m_cassandraPort = cassandraPort;
	    String m_keyspaceName = keyspaceName;

//	    LOG.info("Connecting to {}:{}...", cassandraHost, cassandraPort);
	    Cluster  cluster = Cluster.builder().withPort(m_cassandraPort).addContactPoint(cassandraHost).build();
//	    cluster.getConfiguration().getSocketOptions().setReadTimeoutMillis(HIGHER_TIMEOUT);
	    Session   session = cluster.connect(m_keyspaceName);
//	    LOG.info("Connected.");
	}

	public static void main(String[] args) {
		TestCassandraConnection bdt = new TestCassandraConnection("127.0.0.1", 9042, "CQLTest");
	}

}
