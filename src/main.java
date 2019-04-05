import java.util.List;

import api.MySQLConnect;

public class main {

	public static void main(String[] args) {
		
		MySQLConnect newConnect = new MySQLConnect("localhost:3313","component","root","P@ssw0rd");
		MySQLConnect newConnect2 = new MySQLConnect("localhost:3313","component","jsj","P@ssw0rd");
		MySQLConnect newConnect3 = new MySQLConnect("localhost:3313","component2","root","P@ssw0rd");
		
		
		System.out.println("== DataBase: component - User: root =====");
		List<List> list = newConnect.executeQuery("Select * from test");
		
		for (List<String> list2 : list) {
			String r = "";
			for (String string : list2) {
				r = r + "- " + string;
			}
			System.out.println(r);
		}
		
		newConnect.executeQuery("INSERT INTO test (testcol) VALUES ('Sean')");
		newConnect.executeQuery("INSERT INTO test (testcol) VALUES ('Jordi')");
		newConnect.executeQuery("INSERT INTO test (testcol) VALUES ('Jaime')");
		newConnect.executeQuery("call showTest()");
		
		newConnect.executeQuery("update test set testcol = 'Fran' where testcol = 'Jaime'");
		
		newConnect.executeQuery("delete from test where testcol = 'Sean'");

		
		System.out.println("== DataBase: component - User: jsj =====");
		List<List> new1 = newConnect2.executeQuery("Select * from test");
		
		for (List<String> new2 : new1) {
			String r = "";
			for (String string : new2) {
				r = r + "- " + string;
			}
			System.out.println(r);
		}
		
		newConnect2.executeQuery("INSERT INTO test (testcol) VALUES ('Lean')");
		newConnect2.executeQuery("INSERT INTO test (testcol) VALUES ('Maria')");
		
		newConnect.executeQuery("update test set testcol = 'Selena' where testcol = 'Maria'");
		
		
		System.out.println("== DataBase: component2 - User: root =====");
		
		List<List> new3 = newConnect3.executeQuery("Select * from test");
		
		for (List<String> new4 : new3) {
			String r = "";
			for (String string : new4) {
				r = r + "- " + string;
			}
			System.out.println(r);
		}
		newConnect3.executeQuery("INSERT INTO test (testcol) VALUES ('Ari')");
		newConnect3.executeQuery("update test set testcol = 'Ari' where testcol = 'Irene'");
		
		System.out.println("======== Consulta de las querys =========");
		
		newConnect.searchDatabaseType("component2", "insert");
		System.out.println("==========================================");
		newConnect.searchDatabaseUser("component", "root");
		System.out.println("==========================================");
		newConnect.searchDatabaseUserType("component", "root", "insert");

	}

}
