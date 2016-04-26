package br.unipe.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.conta.Conta;

public class Main {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:1521/bancario";
		String login = "postgres";
		String senha = "123456";
		Conta conta;
		List<Conta>listaContas=new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,login,senha);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from conta");
			while(rs.next()){
				int id = rs.getInt("id");
				String numero = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				boolean status = rs.getBoolean("status");
				String titular = rs.getString("titular");		
				conta = new Conta(id,numero,saldo,status,titular);
				listaContas.add(conta);
			}
			
			for(Conta i : listaContas){
				System.out.println(i);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
