package com.skh.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empId;  

	@Column
	private String empName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date empDOJ;

	private Double empSalary;

	private Boolean isPermenentEmp;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID_FK")
	private List<Address> empAddress;
	

	public Employee() {

	}

	public Employee(Integer empId, String empName, Date empDOJ, Double empSalary, Boolean isPermenentEmp,
			List<Address> empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empDOJ = empDOJ;
		this.empSalary = empSalary;
		this.isPermenentEmp = isPermenentEmp;
		this.empAddress = empAddress;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public Boolean getIsPermenentEmp() {
		return isPermenentEmp;
	}

	public void setIsPermenentEmp(Boolean isPermenentEmp) {
		this.isPermenentEmp = isPermenentEmp;
	}

	public List<Address> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(List<Address> empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAddress, empDOJ, empId, empName, empSalary, isPermenentEmp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empAddress, other.empAddress) && Objects.equals(empDOJ, other.empDOJ)
				&& Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empSalary, other.empSalary) && Objects.equals(isPermenentEmp, other.isPermenentEmp);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDOJ=" + empDOJ + ", empSalary=" + empSalary
				+ ", isPermenentEmp=" + isPermenentEmp + ", empAddress=" + empAddress + "]";
	}

}
