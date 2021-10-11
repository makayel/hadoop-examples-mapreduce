package com.opstty;

import com.opstty.job.Spiecies;
import com.opstty.job.WordCount;
import com.opstty.job.district;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("list", district.class,
                    "A map/reduce program that list the arrondissment where there are trees.");
            programDriver.addClass("espece", Spiecies.class,
                    "A map/reduce program that list the different species.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
