package Csv;

import Entity.AllResources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by adyachenko on 11.10.16.
 */
public class Csv {
    public static void generateCsvFile(List<AllResources> allResources)
    {
        try
        {
            FileWriter writer = new FileWriter("results.csv");
            writer.append("processCPU");
            writer.append(',');
            writer.append("processMem");
            writer.append(',');
            writer.append("systemCPU");
            writer.append(',');
            writer.append("systemFreeMem");
            writer.append(',');
            writer.append("systemTotalMem");
            writer.append('\n');

            for (AllResources allResource : allResources) {
                writer.append(allResource.processCPU);
                writer.append(',');
                writer.append(allResource.processMem);
                writer.append(',');
                writer.append(allResource.systemCPU);
                writer.append(',');
                writer.append(allResource.systemFreeMem);
                writer.append(',');
                writer.append(allResource.systemTotalMem);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
