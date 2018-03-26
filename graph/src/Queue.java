
public class Queue {
	//the size of the array
		int arraySize;
		//the array that the elements will be stored in 
		private int [] queue;
		//the head of the queue
		int head = -1;
		//the tail of the  queue 
		int tail = -1;
		// this is the constructor of the queue
		//the passed value  is the size of the queue
		public Queue (int a)
		{
			arraySize = a;
			queue = new int [a];
		}
		//checks if the queue us full
		public boolean isFull()
		{
			if((head == 0 && tail == arraySize -1 ) || (tail == (head-1)))
					{
						return true;
					}
			else {
				return false;
			}
		}
		//checks if the queue is empty
		public boolean isEmpty()
		{
			if(head ==-1 && tail == -1)
			{
				return true;
			}
			else 
				return false;
		}
		//enqueue an element 
		public void enqueue(int n)
		{
			if(head == -1 && tail == -1)
			{
				head = 0;
				tail = 0;
				queue[tail] = n;
				
			}
			else if(isFull()) {
				System.out.println("Full");
				return;
			}
			else 
			{
				tail = (tail+1) % arraySize;
				queue[tail] = n;
			}
		}
		//dequeues an element 
		public Integer dequeue () 
		{
			if(isEmpty())
			{
				System.out.println("Is empty");
				return null;
			}
			else if(head == tail)
			{
				int temp = queue[head];
				head = -1;
				tail = -1;
				return temp;
			}
			else {
				int temp = queue[head];
				head = (head + 1) %(arraySize -1 );
				return temp;
				
			}
		}
}
