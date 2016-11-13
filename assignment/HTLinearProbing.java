public class HTLinearProbing extends OpenAddressingBGU {
	//A class  that represents a HashTable of LinearProbing,get Function and size of the array.
	//all element that enter is new

	
	  public HTLinearProbing(Function hashFunction, int size) {
		super(hashFunction, size);
		for(int i=0;i<super.flags.length;i++)//put true in all the array of flags-empty place,
		{
			super.flags[i]=true;
		}
	}
	public  void insert(Object key ,Object data)//add a element to the array if the place is empty,all element that enter is new.
	    {
		
		int  hashFunctionResult=super.hashFunction.h(key);

		HashObject Insert= new HashObject(key,data);
		for(int i=0;i<super.hashTable.length;i++)
		{
			if(super.flags[((int)hashFunctionResult)+i]==true)//check if the place is empty
			{
				super.flags[((int)hashFunctionResult)+i]=false;//change to full.
				super.hashTable[((int)hashFunctionResult)+i]=Insert;
				return;
			}
		}

	    }
	    public  void delete(Object key)//delete the element with key.if  we check all the places and the element is not in the array do return
	    {
	    	int  hashFunctionResult=super.hashFunction.h(key);
			for(int i=((int)hashFunctionResult);i<super.hashTable.length;i++)
			{
				if( super.flags[i]==false&&((HashObject) super.hashTable[i]).getKey()==key)
				{
					super.flags[i]=true;//change the place to empty
				}
			
			}
			for(int j=((int)hashFunctionResult);j>=0;j--)//if its the end of the array
			{
				if(super.flags[j]==false&&((HashObject) super.hashTable[j]).getKey().equals(key))
				{
					super.flags[j]=true;
				}
			}
			return;


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
			int  hashFunctionResult=super.hashFunction.h(key);
			for(int i=((int)hashFunctionResult);i<super.hashTable.length;i++)
			{
				if(super.flags[i]==false&&((HashObject) super.hashTable[i]).getKey()==key)
				{
					return ((HashObject) super.hashTable[i]).getData();
				}
			
			}
			for(int j=((int)hashFunctionResult);j>=0;j--)
			{
				if(super.flags[j]==false&&((HashObject) super.hashTable[j]).getKey().equals(key))
				{
					return ((HashObject) super.hashTable[j]).getData();
				}
			}
			return null;

	    }
}
