package Test;

import implementation.*;
import myProject.*;
import java.util.*;
import java.sql.Date;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        UserImpl userData = new UserImpl();
        ProjectImpl projectData = new ProjectImpl();
        MaterialImpl materialData = new MaterialImpl();
        StockImpl stockData = new StockImpl();
        UsageLogImpl usageLogData = new UsageLogImpl();

        User currentUser = null;
        System.out.println("==== Welcome to MayureshProject ====");

        while (currentUser == null) {
            System.out.println("\n1. Register\n2. Login");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPassword(password);
                boolean registered = userData.register(newUser);
                if (registered) {
                    System.out.println("Registration successful! Please login.");
                } else {
                    System.out.println("Registration failed.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                currentUser = userData.login(username, password);
                if (currentUser != null) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid credentials, try again.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

      
        boolean exit = false;
        while (!exit) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Create Project");
            System.out.println("2. View Projects");
            System.out.println("3. Add Material");
            System.out.println("4. View Materials");
            System.out.println("5. Assign Material to Project (Stock)");
            System.out.println("6. View Project Stock");
            System.out.println("7. Log Material Usage");
            System.out.println("8. View Usage Logs");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int menuChoice = sc.nextInt();
            sc.nextLine(); 

            switch (menuChoice) {
                case 1:
                    System.out.print("Enter project name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter project location: ");
                    String location = sc.nextLine();
                    Project project = new Project();
                    project.setUserId(currentUser.getUserId());
                    project.setProjectName(pname);
                    project.setLocation(location);
                    if (projectData.addProject(project)) {
                        System.out.println("Project added successfully!");
                    }
                    break;

                case 2:
                    System.out.println("Your Projects:");
                    List<Project> projects = projectData.getProjectsByUser(currentUser.getUserId());
                    for (Project p : projects) {
                        System.out.println(p.getProjectId() + ". " + p.getProjectName() + " (" + p.getLocation() + ")");
                    }
                    break;

                case 3:
                    System.out.print("Enter material name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter unit (e.g., kg, litre, piece): ");
                    String unit = sc.nextLine();
                    Material material = new Material();
                    material.setName(mname);
                    material.setUnit(unit);
                    if (materialData.addMaterial(material)) {
                        System.out.println("Material added successfully!");
                    }
                    break;

                case 4:
                    System.out.println("Available Materials:");
                    List<Material> materials = materialData.getAllMaterials();
                    for (Material m : materials) {
                        System.out.println(m.getMaterialId() + ". " + m.getName() + " (" + m.getUnit() + ")");
                    }
                    break;

                case 5:
                    System.out.print("Enter project id: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter material id: ");
                    int mid = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    double qty = sc.nextDouble();
                    Stock stock = new Stock();
                    stock.setProjectId(pid);
                    stock.setMaterialId(mid);
                    stock.setQuantity(qty);
                    if (stockData.assignMaterialToProject(stock)) {
                        System.out.println("Material assigned to project stock successfully!");
                    }
                    break;

                case 6:
                    System.out.print("Enter project id: ");
                    int pid2 = sc.nextInt();
                    System.out.println("Project Stock:");
                    List<Stock> stockList = stockData.getStockByProject(pid2);
                    for (Stock s : stockList) {
                        System.out.println("Material ID: " + s.getMaterialId() + ", Quantity: " + s.getQuantity());
                        
                    }
                    break;

                case 7:
                    System.out.print("Enter project id: ");
                    int pid3 = sc.nextInt();
                    System.out.print("Enter material id: ");
                    int mid3 = sc.nextInt();
                    System.out.print("Enter used quantity: ");
                    double usedQty = sc.nextDouble();
                    UsageLog usageLog = new UsageLog();
                    usageLog.setProjectId(pid3);
                    usageLog.setMaterialId(mid3);
                    usageLog.setUsedQuantity(usedQty);
                    usageLog.setUsedDate(new Date(System.currentTimeMillis()));
                    if (usageLogData.logUsage(usageLog)) {
                        System.out.println("Usage logged and stock updated!");
                    }
                    break;

                case 8:
                    System.out.print("Enter project id: ");
                    int pid4 = sc.nextInt();
                    System.out.println("Usage Logs:");
                    List<UsageLog> usageLogs = usageLogData.getUsageByProject(pid4);
                    for (UsageLog ul : usageLogs) {
                        System.out.println("Material ID: " + ul.getMaterialId() + ", Used Quantity: " + ul.getUsedQuantity() + ", Date: " + ul.getUsedDate());
                    }
                    break;

                case 9:
                    exit = true;
                    System.out.println("Thank you for using MayureshProject!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}
