import java.util.List;
import java.util.LinkedList;
//A class  that represents a Garage of car ,get the number of the traets that car can do.


public class GarageSim{
	
	private  LinkedList <  CarTest> CarTest;//list of all the treats
	private  Function h1;//hash Function
	private HTChaining hashTableCar;//hash table array
	private int NumberOfTreats;//the number of treats that car can do
	int firstTreat=0;
	
	public   GarageSim(int n)
	{

    this. h1 = new Function1();
	this. hashTableCar = new HTChaining(h1,11);
   this.CarTest  = new LinkedList();
   CarTest.addLast( new CarTest (0));
   this. NumberOfTreats=n;

	}
	
	public void insert(Integer x)//get the number of new car, and put the number in the element "car" and add to the element the  first treat
	{
		if((hashTableCar.find(x)==null))//if x is not inserted yet.
		{
			Object zero= CarTest.get(0);
			Car y = new Car (x,zero);
			hashTableCar.insert(x, y);//inserted to the Hash table-Chaining the cat -the key is the number of the cat ,data is element car
			CarTest.get(0).addToList(y);//add the new car to treats list.
			System.out.println("car " + x + " is inserted");
			firstTreat=0;
			return;
		}
		System.out.println("car " + x + " is already in");

	}
	public void treat()//add treats to the car with the least treats. have n+1 treats
	{
		for(int i=firstTreat;i<((int)CarTest.size()) ;i++)
		{
			if(CarTest.get(i).getCars().size()>0&&CarTest.get(i).getTestNumber()<NumberOfTreats+1)
			{
				Car TempCar=(CarTest.get(i).removeFromList());
				if(CarTest.size()>i+1&&CarTest.get(i+1).getTestNumber()==i+1)//if the treats is already exist.
				{
				TempCar.setCarTest(CarTest.get(i+1));
				CarTest.get(i+1).addToList(TempCar);
				int x=i+1;
				System.out.println("car "+ TempCar.getNumber()+" is moved to treament "+ x );
				if(CarTest.get(firstTreat).getCars().size()==0)//the first treat the have car
					firstTreat++;
				return;
				}
				else//build new treat.
				{
					LinkedList <  CarTest> TempCarTest=new LinkedList();
					CarTest tempCarTest= new CarTest(i+1);
					CarTest.add(i+1, tempCarTest);
					TempCar.setCarTest(tempCarTest);
					CarTest.get(i+1).addToList(TempCar);
					int x=i+1;
					 System.out.println("car "+ TempCar.getNumber()+ " is moved to treament "+ x );
						if(CarTest.get(firstTreat).getCars().size()==0)//the first treat the have car
							firstTreat++;
					 return;
					  
				}
				
			}
		}
		

		
	}
	public int times(Integer x)//return the number of the car that her number is x ,and print it. if x is not in the hash table throw RuntimeException
	{
		 Car TempCar=  (Car) hashTableCar.find(x);
		 if(TempCar!=null)
		 {
			 Object TempCarList=TempCar.getCarTest();
			 int Times= ((CarTest) TempCarList).getTestNumber();
			 System.out.println("car " + TempCar.getNumber()+ " passed "+Times+ " trearments" );
			 return Times;
		 }
		  throw new RuntimeException(" Car number is not in the hashTable!! .");
		
  }
	
}
