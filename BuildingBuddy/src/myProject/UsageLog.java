package myProject;

import java.sql.Date;
public class UsageLog {
	private int usageId;
    private int projectId;
    private int materialId;
    private double usedQuantity;
    private Date usedDate;
	public UsageLog() {
		super();
	}
	public UsageLog(int usageId, int projectId, int materialId, double usedQuantity, Date usedDate) {
		super();
		this.usageId = usageId;
		this.projectId = projectId;
		this.materialId = materialId;
		this.usedQuantity = usedQuantity;
		this.usedDate = usedDate;
	}
	public int getUsageId() {
		return usageId;
	}
	public void setUsageId(int usageId) {
		this.usageId = usageId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public double getUsedQuantity() {
		return usedQuantity;
	}
	public void setUsedQuantity(double usedQuantity) {
		this.usedQuantity = usedQuantity;
	}
	public Date getUsedDate() {
		return usedDate;
	}
	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}
    
	
    
}
