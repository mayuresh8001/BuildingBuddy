package data;

import java.util.List;

import myProject.Project;

public interface ProjectData {
	boolean addProject(Project project);
    List<Project> getProjectsByUser(int userId);
}
