package Assignment8;

public class PayrollTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			Payroll employee = new Payroll("", -1);
			
			employee.setHourlyPayRate(16);
			employee.setHoursWorked(86);
			
			
		}
		catch (StringException | IdException | PayRateException | HoursWorkedException e){
			System.out.println("Error - " + e.getMessage());
		}

		try{
			Payroll emp = new Payroll("", 5);
		}
		catch(StringException | IdException e){
			System.out.println("Error - " + e.getMessage());
		}
		try{
			Payroll emep = new Payroll("Chronos", 55);
			emep.setHourlyPayRate(0);
		}
		catch(PayRateException | IdException | StringException e){
			System.out.println("Error - " + e.getMessage());
		}
		try{
			Payroll emp2 = new Payroll("Smith", 999);
			emp2.setHoursWorked(89);
		}
		catch(StringException | IdException | HoursWorkedException e){
			System.out.println("Error - " + e.getMessage());
		}
		
		
		
	}

}
