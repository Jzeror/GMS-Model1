package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,CONFIRM_ID,COUNT_MEMBER,UPDATE,DELETE;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = " SELECT MEM_ID ADMINID , " +
					" TEAM_ID TEAMID ," + " NAME , " +
					" AGE ," + " ROLL , " + " PASSWORD "	+
			" FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'  AND  PASSWORD  LIKE  '%s' ";	
			break;
		case INSERT_MEMBER:
			query = " INSERT INTO MEMBER (MEM_ID, NAME, PASSWORD, SSN, AGE) VALUES ( '%s', '%s', '%s' , '%s' , '%s') ";
			break;
		case CONFIRM_ID:
			query = " SELECT MEM_ID ADMINID " 	+
	" FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'   ";
			break;
		case COUNT_MEMBER : 
			query = "SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case UPDATE : 
			query = "UPDATE MEMBER SET PASSWORD = '%s' "
					+ " WHERE PASSWORD LIKE '%s' AND MEM_ID LIKE '%s' ";
			break;
		case DELETE : 
			query = "DELETE FROM MEMBER WHERE PASSWORD LIKE '%s' AND MEM_ID LIKE '%s' ";
		}
		
		return query;
	}
}
