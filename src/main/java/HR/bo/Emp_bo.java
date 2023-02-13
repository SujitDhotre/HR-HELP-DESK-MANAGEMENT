package HR.bo;

public class Emp_bo {

		private int id;
		private String name;
		private String phone;
		private String email;
		private String Password;
		private String doj;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String Password) {
			this.Password = Password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
		public String getDoj() {
			return doj;
		}
		public void setDoj(String doj) {
			this.doj = doj;
		}
		@Override
		public String toString() {
			return "Emp_bo [name=" + name + ", phone=" + phone + ", email=" + email + ", Password=" + Password + ", doj="
					+ doj + "]";
		}
		
		
		

	}

