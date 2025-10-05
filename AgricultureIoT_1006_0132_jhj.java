// 代码生成时间: 2025-10-06 01:32:20
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Managed Bean for Agriculture IoT application
 */
@ManagedBean
@SessionScoped
public class AgricultureIoT implements Serializable {

    private static final long serialVersionUID = 1L;

    // Map to store sensor data
    private Map<String, String> sensorDataMap = new HashMap<>();

    /**
     * Default constructor
     */
    public AgricultureIoT() {
        initializeSensorDataMap();
    }

    /**
     * Initialize sensor data map with mock data
     */
    private void initializeSensorDataMap() {
        // Add mock sensor data for demonstration
        sensorDataMap.put("Temperature", "25°C");
        sensorDataMap.put("Humidity", "60%");
        sensorDataMap.put("SoilMoisture", "40%");
    }

    /**
     * Get sensor data map
     *
     * @return Map containing sensor data
     */
    public Map<String, String> getSensorDataMap() {
        return sensorDataMap;
    }

    /**
     * Process incoming sensor data from IoT devices
     *
     * @param sensorName Name of the sensor
     * @param sensorValue Value received from the sensor
     */
    public void processSensorData(String sensorName, String sensorValue) {
        if (sensorName == null || sensorValue == null) {
            throw new IllegalArgumentException("Sensor name and value cannot be null");
        }
        try {
            sensorDataMap.put(sensorName, sensorValue);
        } catch (Exception e) {
            // Handle any unexpected errors
            System.err.println("Error processing sensor data: " + e.getMessage());
        }
    }
}
