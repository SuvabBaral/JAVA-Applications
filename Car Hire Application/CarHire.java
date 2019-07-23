import java.lang.*;
import java.io.*;
public class CarHire{
	final double dailyRate1=34.5;
	final double dailyRate2=30.5;
	final double dailyRate3=22.5;
	private String customerName="";
	private String licenseNumber="";
	private int days_hired=0;
	private double rent=0.0;
	private  int max_num=0;
	private static int total_entries=0;
	private static int total_days=0;
	private static double total_rent=0.0;

	public CarHire(int num){
		max_num=num;
	}
	public CarHire(String name, String liscense,int day){
		this.customerName=name;
		this.licenseNumber=liscense;
		this.days_hired=day;
		total_entries++;
		total_days+=days_hired;
	}
	public static int  getTotalEntries(){
		return total_entries;
	}
	public static double getTotalRental(){
		return total_rent;
	}
	public static int  getAvgDays(){
		return (total_days/total_entries);
	}
	public void setcustomerName(String name){
		this.customerName=name;
	}
	public void setlicenseNumber(String number){
		this.licenseNumber=number;
	}
	public void setDays(int  days){
		this.days_hired=days;
	}
	public void setRental(double rental){
		this.rent=rental;
	}
	public double getRental(){
		return this.rent;
	}

	public String getcustomerName(){
		return this.customerName;
	}
	public String getlicenseNumber(){
		return this.licenseNumber;
	}
	public int getdaysHired(){
		return this.days_hired;
	}
	public double calculateHireRental(){
		if(this.days_hired>=1 && this.days_hired<=3){
			rent=( dailyRate1 * days_hired);
			total_rent+=rent;
			return rent;
		}
		else if (days_hired >=4 && days_hired<=7){
			rent=(3*dailyRate1 + (this.days_hired-3)*dailyRate2);
			total_rent+=rent;
			return rent;
		}
		else{
			rent=(3*dailyRate1 + 4*dailyRate2 + (this.days_hired-7)*dailyRate3);
			total_rent+=rent;
			return rent;


	}
}
}