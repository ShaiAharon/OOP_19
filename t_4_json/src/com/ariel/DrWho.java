package com.ariel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DrWho {
    String title = "Dr.";
    String name = "Who";
    String type = "TimeLord";
    int doctor_num = 8;
    int heart_num = 2;
    ArrayList<companion> companions = new ArrayList<companion>(
            Arrays.asList(new companion()
            ));
}
