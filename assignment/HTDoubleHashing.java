public class HTDoubleHashing extends OpenAddressingBGU {
	//A class  that represents a Garage of car ,get the number of the traets that car can do.

    protected Function hashFunction2;

    public HTDoubleHashing(Function hashFunction1,Function hashFunction2, int size) {
		super(hashFunction1, size);
		this.hashFunction2=hashFunction2;
		for(int i=0;i<super.flags.length;i++)//put true in all the array of flags-empty place,
		{
			super.flags[i]=true;
		}
	}
	public  void insert(Object key ,Object data)//add a element to the array if the place is empty,all element that enter is new
    {
		boolean FromStart=false;;
		int counter=0;
		HashObject Insert= new HashObject(key,data);
		int  hashFunctionResult1=super.hashFunction.h(key);
		int  hashFunctionResult2=this.hashFunction2.h(key);	
		if(super.flags[(int)hashFunctionResult1]==true)//check that the place is empty
		{
			super.hashTable[(int)hashFunctionResult1]=Insert;
			super.flags[(int)hashFunctionResult1]=false;//change it to full
		}
		else
		{
			int i=(int)hashFunctionResult1;
			while(i<super.hashTable.length)

			{
			
				if(i==(int)hashFunctionResult1)
				{
					counter++;
				}
				if(super.flags[i]==true)
				{
						super.hashTable[i]=Insert;
						super.flags[i]=false;
						return;

					
				}
				
				
					if(i+((int)hashFunctionResult2)>=super.hashTable.length)//its the end of the array
						{
							int x=super.hashTable.length-i-1;
								i=((int)hashFunctionResult2)-x-1;
								// FromStart=true;
						}
					else
						i=i+(int)hashFunctionResult2;
					if(counter>=2)
						return ;
			}
		}

		
    }
    public  void delete(Object key)//delete the element with key.if counter is more than one we check all the places and the element is not in the array
    {
    	int counter=0;//counter the number of time the index is hashFunctionResult1
    	int  hashFunctionResult1=super.hashFunction.h(key);
		int  hashFunctionResult2=this.hashFunction2.h(key);	
		if(super.flags[(int)hashFunctionResult1]==false&& ((HashObject) super.hashTable[(int)hashFunctionResult1]).getKey().equals(key))
		{
			super.flags[(int)hashFunctionResult1]=true;//change the place to empty
			return;
		}
		else
		{
			int i=(int)hashFunctionResult1;
			while(i<super.hashTable.length)
			{
				if(i==(int)hashFunctionResult1)
					counter++;
				if(super.flags[i]==false&&((HashObject) super.hashTable[i]).getKey().equals(key))
				{
					super.flags[i]=true;//change the place to empty
					return;

					
				}
				
				
				if(i+((int)hashFunctionResult2)>=super.hashTable.length)//its the end of the array
				{
					int x=super.hashTable.length-i-1;
						i=((int)hashFunctionResult2)-x-1;
				}
				else
					i=i+(int)hashFunctionResult2;

					if(counter>=2)//if its check the same place more than one time, the element is not in the array
						return ;
			}
		}

    	
    	
    	
    }
    public  boolean isEmpty()//return true if all the i in array flags is empty,
    {
    	for(int i=0;i<super.hashTable.length;i++)
    	{
    		if(super.flags[i]==false)
    			return false;
    	}
    	return true;
    }
    public  Object find(Object key)//find the element that his "key" is key, if it is not in the array return null;
    {
    	int counter=0;//counter the number of time the index is hashFunctionResult1
    	int  hashFunctionResult1=super.hashFunction.h(key);
		int  hashFunctionResult2=this.hashFunction2.h(key);	
		if(super.flags[(int)hashFunctionResult1]==false&& ((HashObject) super.hashTable[(int)hashFunctionResult1]).getKey().equals(key))
		{
			return ((HashObject) super.hashTable[(int)hashFunctionResult1]).getData();
		}
		else
		{
			int i=(int)hashFunctionResult1;
			while(i<super.hashTable.length)
			{
				if(i==(int)hashFunctionResult1)
					counter++;
				if(super.flags[i]==false&&((HashObject) super.hashTable[i]).getKey().equals(key))
				{
						
					return ((HashObject) super.hashTable[i]).getData();

					
				}
				
				
				if(i+((int)hashFunctionResult2)>=super.hashTable.length)//its the end of the array
				{
					int x=super.hashTable.length-i-1;
						i=((int)hashFunctionResult2)-x-1;
				}
				else
					i=i+(int)hashFunctionResult2;

					if(counter>=2)//if its check the same place more than one time, the element is not in the array
						return null;
			}
		}

		return null;
    }
    
}
