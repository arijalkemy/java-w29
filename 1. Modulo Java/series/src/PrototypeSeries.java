public class PrototypeSeries {
    private Integer initialValue;
    private Integer accumulatedValue;
    private final Integer serialNumber;

    public PrototypeSeries(Integer serialNumber, Integer initialValue) {
        this.initialValue = initialValue;
        this.accumulatedValue = initialValue;
        this.serialNumber = serialNumber;
    }

    public PrototypeSeries(Integer serialNumber) {
        this.serialNumber = serialNumber;
        this.accumulatedValue = 0;
        this.initialValue = 0;
    }

    public void next() {
        accumulatedValue += serialNumber;
        System.out.println(accumulatedValue);
    }

    public void restart() {
        accumulatedValue = initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
        accumulatedValue = initialValue;
    }
}
