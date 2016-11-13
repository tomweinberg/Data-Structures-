

public class Car {

//A class  that represents a car ,get the number of the car and a list of the number of the source treat.
	
	Integer number;//the number of the car
    Object CarTest;//the list of the treats of the car

    public Car(Integer number ,  Object CarTest){
        this.number = number;
        this.  CarTest =   CarTest;
    }

    public Integer getNumber() {
        return number;
    }
    

    public Object getCarTest() {
        return CarTest;
    }
    public void setCarTest(Object CarTest)
    {
        this.  CarTest =   CarTest;

    }    
}
