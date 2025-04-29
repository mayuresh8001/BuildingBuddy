package implementation;

import data.UsageLogData;
import myProject.DBConnection;
import myProject.UsageLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsageLogImpl implements UsageLogData {
    @Override
    public boolean logUsage(UsageLog usage) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            String logSql = "INSERT INTO usage_logs (project_id, material_id, used_quantity, used_date) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(logSql);
            ps.setInt(1, usage.getProjectId());
            ps.setInt(2, usage.getMaterialId());
            ps.setDouble(3, usage.getUsedQuantity());
            ps.setDate(4, usage.getUsedDate());
            ps.executeUpdate();

            String updateStockSql = "UPDATE stock SET quantity = quantity - ? WHERE project_id = ? AND material_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateStockSql);
            ps2.setDouble(1, usage.getUsedQuantity());
            ps2.setInt(2, usage.getProjectId());
            ps2.setInt(3, usage.getMaterialId());
            ps2.executeUpdate();

            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Usage Log Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<UsageLog> getUsageByProject(int projectId) {
        List<UsageLog> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM usage_logs WHERE project_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsageLog u = new UsageLog();
                u.setUsageId(rs.getInt("usage_id"));
                u.setProjectId(rs.getInt("project_id"));
                u.setMaterialId(rs.getInt("material_id"));
                u.setUsedQuantity(rs.getDouble("used_quantity"));
                u.setUsedDate(rs.getDate("used_date"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Fetch Usage Error: " + e.getMessage());
        }
        return list;
    }
}
