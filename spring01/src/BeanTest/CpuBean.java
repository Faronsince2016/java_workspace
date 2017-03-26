package BeanTest;

public class CpuBean {
    private String cpu;
    private String hdd;
    private String mainbord;
    
    
    
	public CpuBean() {
	}
	
	public CpuBean(String cpu, String hdd, String mainbord) {
		this.cpu = cpu;
		this.hdd = hdd;
		this.mainbord = mainbord;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public String getMainbord() {
		return mainbord;
	}
	public void setMainbord(String mainbord) {
		this.mainbord = mainbord;
	}
	public void show() {
		System.out.println("cpu:"+cpu);
		System.out.println("hdd:"+hdd);
		System.out.println("mainbord£º"+mainbord);
	}
}
