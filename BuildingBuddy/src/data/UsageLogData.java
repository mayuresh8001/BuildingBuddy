package data;

import java.util.List;

import myProject.UsageLog;

public interface UsageLogData {
	   boolean logUsage(UsageLog usage);
	    List<UsageLog> getUsageByProject(int projectId);
}
