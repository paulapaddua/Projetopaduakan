package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/cadastro";
	private String user = "root";
	private String password = "padua123";
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void inserirContato(Cliente clientes) {
		String create = "insert into clientes (nome,cpf,email,celular,adulto) values(?,?,?,?,?)";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, clientes.getNome());
			pst.setString(2, clientes.getCpf());
			pst.setString(3, clientes.getEmail());
			pst.setString(4, clientes.getCelular());
			pst.setString(5, clientes.getAdulto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
		public ArrayList<Cliente> ListarContatos() {
			ArrayList<Cliente> clientes = new ArrayList<>();
			String read = "select * from clientes order by nome";
			
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					String idcon = rs.getString(1);
					String nome = rs.getString(2);
					String cpf = rs.getString(3);
					String email = rs.getString(4);
					String celular = rs.getString(5);
					String adulto = rs.getString(6);
				
					clientes.add(new Cliente(idcon, nome, cpf, email, celular,adulto));
				}

				con.close();
				
				return clientes;
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		public void selecionarContato(Cliente cliente) {
			String select = "select * from clientes where idcon = ?";
			
			try {
				Connection con = conectar();
				
				PreparedStatement pst = con.prepareStatement(select);
				pst.setString(1, cliente.getIdcon());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					cliente.setIdcon(rs.getString(1));
					cliente.setNome(rs.getString(2));
					cliente.setCpf(rs.getString(3));
					cliente.setEmail(rs.getString(4));
					cliente.setCelular(rs.getString(5));
					cliente.setAdulto(rs.getString(6));

					
				}
				con.close();
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void alterarContato(Cliente cliente) {
			
			String update = "update clientes set nome=?, cpf=?, email=?, celular=?, adulto=?, where idcon=?";
			
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, cliente.getNome());
				pst.setString(2, cliente.getCpf());
				pst.setString(3, cliente.getEmail());
				pst.setString(4, cliente.getIdcon());
				pst.setString(5, cliente.getCelular());
				pst.setString(6, cliente.getAdulto());
				pst.executeUpdate();
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void deletarContato(Cliente cliente) {
			String delete = "delete from clientes where idcon=?";
			
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, cliente.getIdcon());
				pst.executeUpdate();
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			} 
		}

}
