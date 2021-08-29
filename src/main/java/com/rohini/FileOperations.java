package com.rohini;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileOperations {
    public void listFiles(String path) {
        Set<File> treeSet = new TreeSet<>(new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareToIgnoreCase(file.getName());
            }
        });

        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] listFiles = dir.listFiles();

            if(listFiles != null && listFiles.length > 0) {
                treeSet.addAll(Arrays.asList(listFiles));
            }

            System.out.println("Total files in directory " + path + ": " + treeSet.size());
            for(File file: treeSet) {
                System.out.println(file.isDirectory() ? "Dir" : "File" + "\t" + file.getName());
            }
        } else {
            System.out.println("Folder " + path + " is not a directory.");
        }

    }

    public void addFile(String path, String fileName) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Folder " + path + " not found.");
            return;
        }

        File file = new File(dir.getAbsolutePath() + File.separator + fileName);
        try {
            boolean result = file.createNewFile();
            if(result) {
                System.out.println("File " + fileName + " was successfully created.");
            } else {
                System.out.println("File " + fileName +  " already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String path, String fileName) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Folder " + path + " not found.");
            return;
        }

        File file = new File(dir.getAbsolutePath() + File.separator + fileName);
        try {
            boolean result = file.delete();
            if(result) {
                System.out.println("File " + fileName + " was successfully deleted.");
            } else {
                System.out.println("File " + fileName + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchFile(String path, String fileName) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Folder " + path + " not found.");
            return;
        }

        File[] files = dir.listFiles();
        if (Algorithms.linearSearch(files, fileName)) {
            System.out.println("File " + fileName + " exists.");
        } else {
            System.out.println("File " + fileName + " not exists.");
        }
    }
}
