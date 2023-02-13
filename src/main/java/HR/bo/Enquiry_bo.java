package HR.bo;

public class Enquiry_bo {
	

	
		private int id;
		private String name;
		private String desc;
		private String email;
		private String date;
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
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "Enquiry_bo [name=" + name + ", desc=" + desc + ", email=" + email + ", date=" + date + "]";
		}
		

	}


