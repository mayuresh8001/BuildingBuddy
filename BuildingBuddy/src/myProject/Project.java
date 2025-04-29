package myProject;

public class Project {
	private int projectId;
    private int userId;
    private String projectName;
    private String location;
	
    public Project() {
		super();
	}
	
    public Project(int projectId, int userId, String projectName, String location) {
		super();
		this.projectId = projectId;
		this.userId = userId;
		this.projectName = projectName;
		this.location = location;
	}
	
    public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
    
    
}
