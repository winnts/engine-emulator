package Entity;

/**
 * Created by adyachenko on 11.10.16.
 */
public class AllResources {
    public static final String PROCESS_CPU = "processCPU";
    public static final String PROCESS_MEM = "processMem";
    public static final String SYSTEM_CPU = "systemCPU";
    public static final String SYSTEM_FREE_MEM = "systemFreeMem";
    public static final String SYSTEM_TOTAL_MEM = "systemTotalMem";
    public static final String PROCESSING_TIME = "processingTime";

    public String processCPU;
    public String processMem;
    public String systemCPU;
    public String systemFreeMem;
    public String systemTotalMem;
    public long processingTime;


    public AllResources(String processCPU, String processMem, String systemCPU, String systemFreeMem, String
            systemTotalMem, long processingTime) {
        this.processCPU = processCPU;
        this.processMem = processMem;
        this.systemCPU = systemCPU;
        this.systemFreeMem = systemFreeMem;
        this.systemTotalMem = systemTotalMem;
        this.processingTime = processingTime;
    }
}
