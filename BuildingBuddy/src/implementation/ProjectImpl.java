package implementation;

import data.ProjectData;
import myProject.DBConnection;
import myProject.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectImpl implements ProjectData {
    @Override
    public boolean addProject(Project project) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO projects (user_id, project_name, location) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, project.getUserId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getLocation());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Add Project Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Project> getProjectsByUser(int userId) {
        List<Project> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM projects WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setProjectId(rs.getInt("project_id"));
                p.setUserId(rs.getInt("user_id"));
                p.setProjectName(rs.getString("project_name"));
                p.setLocation(rs.getString("location"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Fetch Projects Error: " + e.getMessage());
        }
        return list;
    }
}
