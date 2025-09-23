// 代码生成时间: 2025-09-23 09:05:18
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.io.File;
import java.io.IOException;

public class SystemPerformanceMonitor {

    // OperatingSystemMXBean to get system performance metrics
    private OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

    // Retrieves the CPU usage percentage
    public double getSystemCpuLoad() {
        return osBean.getSystemCpuLoad();
    }

    // Retrieves the memory usage in bytes
    public long getMemoryUsage() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    // Retrieves the disk usage in bytes
    public long getDiskUsage(String path) throws IOException {
        File file = new File(path);
        long totalSpace = file.getTotalSpace();
        long usedSpace = totalSpace - file.getFreeSpace();
        return usedSpace;
    }

    // Main method for testing the performance monitoring tool
    public static void main(String[] args) {
        SystemPerformanceMonitor monitor = new SystemPerformanceMonitor();
        try {
            System.out.println("CPU Usage: " + monitor.getSystemCpuLoad() * 100 + "%");
            System.out.println("Memory Usage: " + monitor.getMemoryUsage() + " bytes");
            System.out.println("Disk Usage: " + monitor.getDiskUsage("C:") + " bytes");
        } catch (IOException e) {
            System.err.println("An error occurred while retrieving disk usage: " + e.getMessage());
        }
    }
}