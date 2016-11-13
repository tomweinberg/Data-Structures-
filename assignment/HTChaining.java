import java.util.List;
import java.util.LinkedList;


public class HTChaining extends HashTableBGU {
	
	public HTChaining(Function hashFunction, int size) {
		super(hashFunction, size);
		for(int i=0;i<super.hashTable.length;i++)// put in every place list that empty.
		{
		     LinkedList <HashObject> NewLinkList  = new LinkedList();
		    

			super.hashTable[i]=NewLinkList;
		}
	}
	public  void insert(Object key ,Object data)//add to the HashTabke -Chaining the element, enter by the key.
	
	{
		HashObject Insert= new HashObject(key,data);
		int  hashFunctionResult=super.hashFunction.h(key);
		
		if(((LinkedList) super.hashTable[(int) hashFunctionResult]).isEmpty())
		{
		     LinkedList <HashObject> NewLinkList  = new LinkedList();
		     NewLinkList.addLast(Insert);
			super.hashTable[(int) hashFunctionResult]= NewLinkList;
			
		}
		else
		{
		     LinkedList <HashObject> NewLinkList  = new LinkedList();
			NewLinkList=(LinkedList)super.hashTable[(int) hashFunctionResult];
			NewLinkList.addFirst(Insert);
			super.hashTable[(int) hashFunctionResult]=NewLinkList;
	
		}
		
	}
    public  void delete(Object key)
    {
	     LinkedList <HashObject> NewLinkList  = new LinkedList();

		int  hashFunctionResult=super.hashFunction.h(key);
		int hashFunctionResultint=(int)hashFunctionResult;
		NewLinkList=(LinkedList<HashObject>) super.hashTable[hashFunctionResultint];
		for(int i=0;i<NewLinkList.size();i++)
		{
			if(NewLinkList.get(i).getKey().equals(key))
			{
				NewLinkList.remove(i);
				 super.hashTable[hashFunctionResultint]=NewLinkList;
				 return;
			}

		}
		return;

    	
    	
    }
    public  boolean isEmpty()//check if there is a empty list, if find one that is not  return false 
    {
    	for(int i=0;i<super.hashTable.length;i++)
    	{
    		if(!((LinkedList)super.hashTable[i]).isEmpty())
    			return false;
    	}
    	return true;
    }
    public  Object find(Object key)//find the element the key is his value, return his data.
    {
	     LinkedList <HashObject> NewLinkList  = new LinkedList();
	     int  hashFunctionResult=super.hashFunction.h(key);
	     NewLinkList	= (LinkedList)super.hashTable[(int)hashFunctionResult];

					for(int i=0;i<NewLinkList.size();i++)
					{
						if(NewLinkList.get(i).getKey().equals(key))
						{
							return NewLinkList.get(i).getData();
						}
					}
				
			
			
		
		
		return null;

    }
}
