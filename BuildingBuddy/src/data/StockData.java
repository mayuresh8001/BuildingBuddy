package data;

import java.util.List;

import myProject.Stock;

public interface StockData {
	boolean assignMaterialToProject(Stock stock);
    List<Stock> getStockByProject(int projectId);
}
