package pak.feedback;

public class feedback {

		private int id;
		private String username;
		private String email;
		private String feedback;
		public feedback(int id, String username, String email, String feedback) {
			
			
			this.id = id;
			this.username = username;
			this.email = email;
			this.feedback = feedback;
			
		}
		public int getId() {
			return id;
		}
		public String getUsername() {
			return username;
		}
		public String getEmail() {
			return email;
		}
		public String getFeedback() {
			return feedback;
		}
	
		
		
		
	
}
