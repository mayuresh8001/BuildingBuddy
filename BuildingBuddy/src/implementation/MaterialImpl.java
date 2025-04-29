package implementation;

import data.MaterialData;
import myProject.DBConnection;
import myProject.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialImpl implements MaterialData {
    @Override
    public boolean addMaterial(Material material) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO materials (name, unit) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, material.getName());
            ps.setString(2, material.getUnit());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Add Material Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Material> getAllMaterials() {
        List<Material> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM materials";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Material m = new Material();
                m.setMaterialId(rs.getInt("material_id"));
                m.setName(rs.getString("name"));
                m.setUnit(rs.getString("unit"));
                list.add(m);
            }
        } catch (Exception e) {
            System.out.println("Fetch Materials Error: " + e.getMessage());
        }
        return list;
    }
}