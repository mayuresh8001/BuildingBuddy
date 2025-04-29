package data;

import java.util.List;

import myProject.Material;

public interface MaterialData {
	boolean addMaterial(Material material);
    List<Material> getAllMaterials();
}
