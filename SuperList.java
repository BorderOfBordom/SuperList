import java.util.EmptyStackException;

public class SuperList<E>
{
	ListNode<E> root;
	ListNode<E> end;
	int size;

	public SuperList()
	{
		size = 0;
		root = null;
		end = null;
	}

	public SuperList(ListNode<E> item)
	{
		size = 1;
		root = item;
		end = item;
	}

	public E get(int index)
	{
		return getNode(index).getValue();
	}

	private ListNode<E> getNode(int index)
	{
		ListNode<E> output = root;

		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(index == size-1)
			return end;
		else if(index == 0)
			return output;
		else
		{
			for(int i=0; i<index; i++)
			{
				output = output.getNext();
			}
		}

		return output;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public void add(E value)
	{
		ListNode<E> item = new ListNode<E>(value);
		if(isEmpty())
		{
			root = item;
			end = item;
			size++;
		}
		else
		{
			item.setPrevious(end);
			end.setNext(item);
			end = item;
			size++;
		}
	}

	public void add(int index, E value)
	{
		ListNode<E> item = new ListNode<E>(value);
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}

		if(index == size)
			add(value);
		else if(index == 0)
		{
			root.setPrevious(item);
			item.setNext(root);
			root = item;
			size++;
		}
		else
		{
			ListNode<E> pNode = getNode(index-1);
			ListNode<E> nNode = pNode.getNext();

			item.setPrevious(pNode);
			item.setNext(nNode);
			pNode.setNext(item);
			nNode.setPrevious(item);
			size++;
		}
	}

	public boolean contains(E value)
	{
		boolean output = false;
		ListNode<E> temp = root;
		for(int i=0; i<size; i++)
		{
			if(temp.getValue().equals(value))
			{
				output = true;
				break;
			}
			else
			{
				temp = temp.getNext();
			}
		}

		return output;
	}

	public void clear()
	{
		root = null;
		end = null;
		size = 0;
	}

	public E remove(int index)
	{
		E value = null;

		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(size == 1)
		{
			value=root.getValue();
			clear();
			return value;
		}


		if(index == size-1)
		{
			value=end.getValue();
			end = end.getPrevious();
			end.setNext(null);
			size--;
		}
		else if(index == 0)
		{
			value=root.getValue();
			root = root.getNext();
			root.setPrevious(null);
			size--;
		}
		else
		{

			ListNode<E> node = getNode(index);
			value=node.getValue();
			ListNode<E> pNode = node.getPrevious();
			ListNode<E> nNode = node.getNext();

			nNode.setPrevious(pNode);
			pNode.setNext(nNode);
			size--;
		}

		return value;
	}

	public void push(E value)
	{
		add(value);
	}

	public E pop()
	{
		if(size <= 0)
		{
			throw new EmptyStackException();
		}
		return remove(size-1);
	}

	public E poll()
	{
		E value = null;
		try
		{
			value = remove(0);
			return value;
		}
		catch(Exception e){}

		return value;
	}

	public int size()
	{
		return size;
	}

	public String toString()
	{
		String output = "[";

		for(int i=0; i<size; i++)
		{
			if(i == size-1)
			{
				output += get(i) + "]";
			}
			else
			{
				output += get(i) + ", ";
			}
		}

		return output;
	}

	public E stackPeek()
	{
		return get(size-1);
	}

	public E queuePeek()
	{
		return get(0);
	}

	public class ListNode<E>
	{
		E value;
		ListNode<E> next;
		ListNode<E> previous;

		public ListNode(E value)
		{
			this.value = value;
			next = null;
			previous = null;
		}

		public E getValue()
		{
			return value;
		}

		public ListNode<E> getNext()
		{
			return next;
		}

		public ListNode<E> getPrevious()
		{
			return previous;
		}

		public void setValue(E value)
		{
			this.value = value;
		}

		public void setNext(ListNode<E> node)
		{
			next = node;
		}

		public void setPrevious(ListNode<E> node)
		{
			previous = node;
		}

		public String toString()
		{
			return value.toString();
		}
	}
}