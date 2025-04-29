package implementation;

import data.StockData;
import myProject.DBConnection;
import myProject.Stock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockImpl implements StockData {
    @Override
    public boolean assignMaterialToProject(Stock stock) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO stock (project_id, material_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stock.getProjectId());
            ps.setInt(2, stock.getMaterialId());
            ps.setDouble(3, stock.getQuantity());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Assign Material Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Stock> getStockByProject(int projectId) {
        List<Stock> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM stock WHERE project_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Stock s = new Stock();
                s.setStockId(rs.getInt("stock_id"));
                s.setProjectId(rs.getInt("project_id"));
                s.setMaterialId(rs.getInt("material_id"));
                s.setQuantity(rs.getDouble("quantity"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Fetch Stock Error: " + e.getMessage());
        }
        return list;
    }
}
