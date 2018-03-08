/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nejm
 */
public class FileService {

    private File[] files;

    public FileService(String name) {
        files = new File(name).listFiles();
    }

    public List<String> showFiles() {
        List<String> list = new ArrayList<>();
        for (File file : files) {
            list.add(file.getName());
            System.out.println("File: " + file.getName());
        }

        return list;
    }
}
