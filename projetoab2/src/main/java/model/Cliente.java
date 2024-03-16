package model;

public class Cliente {

		private String idcon;
		private String nome;
		private String cpf;
		private String email;
		private String celular;
		private String adulto;
		
		
		public Cliente(String idcon, String nome, String cpf, String email, String celular, String adulto) {
			this.idcon = idcon;
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.celular = celular;
			this.adulto = adulto;
		}

		public Cliente () {
			this.idcon = "";
			this.nome = "";
			this.cpf = "";
			this.email = "";
			this.celular = "";
			this.adulto = "";
			
		}

		public String getIdcon() {
			return idcon;
		}

		public void setIdcon(String idcon) {
			this.idcon = idcon;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
			
		}
		public String getCelular() {
			return celular;
		}
		
		public void setCelular(String celular) {
			this.celular = celular;
		}
		
		public String getAdulto() {
			return adulto;
		}
		
		public void setAdulto(String adulto) {
			this.adulto = adulto;
		}
		
		
		
}
