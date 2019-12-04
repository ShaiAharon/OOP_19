package com.ariel.oop.t_5a;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("ThreadMaster");

        String logo_path = "src/logo.txt";
        String logo_str = new String(Files.readAllBytes(Paths.get(logo_path)));
        System.out.println(logo_str);

        int times = 10;
        Thread t1 = new Thread(new Spider(100, times));
        Thread t2 = new Thread(new Man(100, times));

        t1.start();
        t2.start();

//        for (int i = 0; i < 100; ++i) {
//            System.out.println("Does what a spider-man does!!");
//        }
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
