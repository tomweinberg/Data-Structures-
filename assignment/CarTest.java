	import java.util.List;
import java.util.LinkedList;
//A class  that represents a treat ,get the number of the treat.

public class CarTest {


		int testNumber;//the number of the treat between 0 to n+1
		private  LinkedList < Car> CarTest=new LinkedList();//list of all the car the did the number of the treat

		
		public CarTest (int testNumber)
		{
			   this.testNumber=testNumber;

		}
		public int getTestNumber()
		{
			return testNumber;
		}
		public void addToList(Object x)
		{
			
			CarTest.addLast((Car)x);;
		}
		public LinkedList getCars()
		{
			return CarTest;
		}
		
		public Car removeFromList()
		{
			
			Car Temp=CarTest.removeFirst();
			return Temp;
		}

	

}
