package com.rohini;

import java.io.File;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static String rootDir;
    public static FileOperations fileOps = new FileOperations();
    public static void main(String[] args) {
        initApp();
        welcomeScreen();
    }

    public static void initApp() {
        // Init the root director
        rootDir = System.getProperty("rootDir");
        if (rootDir == null) {
            rootDir = "./locker";
        }


    }

    public static void welcomeScreen() {
        System.out.println("==============================================");
        System.out.println("***                                        ***");
        System.out.println("***       Application: LockedMe.com	       ***");
        System.out.println("***     Developer: Rohini Thilagaraj       ***");
        System.out.println("***                                        ***");
        System.out.println("==============================================");

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n");
            System.out.println("---------- Welcome to LockedMe.com ----------");
            System.out.println("Press 1 to list files of an directory.");
            System.out.println("Press 2 to add/delete/search files.");
            System.out.println("Press 3 to close the application.");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            switch(option) {
                case 1 :
                    System.out.println("Type the folder name to view the contents (Type Enter key for root directory) ");

                    Scanner sc1 = new Scanner(System.in);
                    String folderName  = rootDir;
                    if(sc1.hasNextLine()) {
                        folderName =  rootDir + File.separator + sc1.nextLine();
                    }

                    fileOps.listFiles(folderName);
                    break;
                case 2 :
                    displayOptions();
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    System.out.println("Have a good day!");
                    System.exit(0);
                    break;
                default :
                    System.out.println("Please enter 1, 2 or 3.");
                    break;
            }

            System.out.println("----------------------");
            System.out.println("Hit Enter to continue...");
            Scanner scEnter = new Scanner(System.in);
            scEnter.nextLine();
        }
    }

    public static void displayOptions() {
        System.out.println("\n");
        System.out.println("---------- Add/Delete/Search files ----------");
        System.out.println("Type the directory name where you want to Add/Delete/Search (Type Enter key for root directory) ");

        Scanner sc = new Scanner(System.in);
        String folderName  = rootDir;
        if(sc.hasNextLine()) {
            folderName =  rootDir + File.separator + sc.nextLine();
        }

        while(true) {
            System.out.println("Please select one of the operation to perform on directory: " + folderName);
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search a file");
            System.out.println("4. Go to Welcome page");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the filename you want to add: ");
                    Scanner scAddFile = new Scanner(System.in);
                    String addFile = scAddFile.nextLine();

                    fileOps.addFile(folderName, addFile);
                    break;
                case 2:
                    System.out.println("Enter the filename you want to delete: ");
                    Scanner scDeleteFile = new Scanner(System.in);
                    String deleteFile = scDeleteFile.nextLine();

                    fileOps.deleteFile(folderName, deleteFile);
                    break;
                case 3:
                    System.out.println("Enter the filename you want to search: ");
                    Scanner scSearchFile = new Scanner(System.in);
                    String searchFile = scSearchFile.nextLine();

                    fileOps.searchFile(folderName, searchFile);
                    break;
                case 4:
                    System.out.println("Going to welcome page...");
                    return;
                default:
                    System.out.println("Please enter 1, 2, 3 or 4.");
                    break;
            }

            System.out.println("----------------------");
            System.out.println("Hit Enter to continue...");
            Scanner scEnter = new Scanner(System.in);
            scEnter.nextLine();
        }
    }
}
