public class SuperListRunner
{
	public SuperListRunner()
	{
		SuperList<Integer> intList = new SuperList<Integer>();

		for(int i=0; i<30; i++)
		{
			intList.add((int)((Math.random()*1000)+1));
		}

		System.out.println(intList);
		System.out.println(intList.size());

		SuperList<Integer> stackIntList = new SuperList<Integer>();

		int size = intList.size();

		for(int i=0; i<size; i++)
		{
			stackIntList.push(intList.remove(0));
		}

		System.out.println(stackIntList);
		System.out.println(stackIntList.size());

		size = stackIntList.size();

		SuperList<Integer> queueIntList = new SuperList<Integer>();

		for(int i=0; i<size; i++)
		{
			queueIntList.add(stackIntList.pop());
		}

		System.out.println(queueIntList);
		System.out.println(queueIntList.size());


		size = queueIntList.size();

		for(int i=0; i<size; i++)
		{
			intList.add((int)(Math.random()*intList.size()), queueIntList.poll());
		}

		System.out.println(intList);
		System.out.println(intList.size());

		int sum = 0;

		for(int i=0; i<intList.size(); i++)
		{
			sum += intList.get(i);
		}
		System.out.println("SUM: " + sum);


		sum = 0;
		for(int i=0; i<intList.size(); i+=2)
		{
			sum += intList.get(i);
		}
		System.out.println("EVEN INDEX SUM: " + sum);


		sum = 0;
		for(int i=1; i<intList.size(); i+=2)
		{
			sum += intList.get(i);
		}
		System.out.println("ODD INDEX SUM: " + sum);

		size = intList.size();

		for(int i=0; i<size; i++)
		{
			int value = intList.get(i);
			if(value%2 == 0)
			{
				intList.add(value);
			}
		}
		System.out.println(intList);


		for(int i=0; i<intList.size(); i++)
		{
			int value = intList.get(i);
			if(value%3 == 0)
			{
				intList.remove(i);
			}
		}
		System.out.println(intList);
		intList.add(4, 55555);
		System.out.println(intList);

		for(int i=0; i<intList.size()-1; i++)
		{

			int position = i;
			try
			{
				while(intList.get(position) < intList.get(position+1))
				{
					intList.add(position, intList.remove(position+1));
					position--;
				}
			}catch(IndexOutOfBoundsException e)
			{

			}
		}

		System.out.println(intList);

		if(intList.size()%2 == 1)
			System.out.println(intList.get(intList.size()/2+1));
		else
		{
			int med = (intList.get(intList.size()/2) + intList.get(intList.size()/2+1))/2;
			System.out.println(med);
		}

		SuperList<String> stringList = new SuperList<String>();

		String sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		String[] sent = sentence.split(" ");
		for(int i=0; i<sent.length; i++)
		{
			stringList.add(sent[i]);
		}
		System.out.println(stringList);

		for(int i=0; i<stringList.size(); i++)
		{
			if(stringList.get(i).length() <= 3)
				stringList.remove(i);
		}
		System.out.println(stringList);

		for(int i=1; i<stringList.size(); i++)
		{
			String temp = stringList.get(i);
			int position = i-1;
			while(position > -1 && temp.compareTo(stringList.get(position)) < 0)
			{
				stringList.add(position, stringList.remove(position));
				position--;
			}
			stringList.add(position+1, stringList.remove(i));
		}
		System.out.println(stringList);

		double avg = 0;
		for(int i=0; i<stringList.size(); i++)
		{
			avg += stringList.get(i).length();
		}
		avg /= stringList.size();
		System.out.println(avg);
	}

	public static void main(String[] args)
	{
		SuperListRunner app = new SuperListRunner();
	}
}