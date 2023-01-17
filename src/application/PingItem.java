package application;

public class PingItem {
    private String name;
    private String ipAddress;
    public String getName() {
        return name;
    }
    public String getPrice() {
        return ipAddress;
    }
    public PingItem(String name, String ipAddress) {
        super();
        this.name = name;
        this.ipAddress = ipAddress;
    }
	public String getIpAddress() {
		return this.ipAddress;
	}
}