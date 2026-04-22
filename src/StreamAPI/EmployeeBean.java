package StreamAPI;

public class EmployeeBean {

	private long empId;
	private String empName;
	private String empGender;
	private Double empSal;
	private String empDept;
	
	public EmployeeBean(long empId, String empName, String empGender, Double empSal, String empDept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.empSal = empSal;
		this.empDept = empDept;
	}

	public EmployeeBean() {

	}

	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", empGender=" + empGender + ", empSal="
				+ empSal + ", empDept=" + empDept + "]";
	}
	
	
}
