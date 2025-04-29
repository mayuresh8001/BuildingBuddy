package myProject;

public class Material {
	private int materialId;
    private String name;
    private String unit;
	
    public Material() {
		super();
	}

	public Material(int materialId, String name, String unit) {
		super();
		this.materialId = materialId;
		this.name = name;
		this.unit = unit;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

    
    
}
