package myProject;

public class Stock {
	private int stockId;
    private int projectId;
    private int materialId;
    private double quantity;
   
	
    public Stock() {
		super();
	}

	public Stock(int stockId, int projectId, int materialId, double quantity) {
		super();
		this.stockId = stockId;
		this.projectId = projectId;
		this.materialId = materialId;
		this.quantity = quantity;

	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

    
	
    
}
