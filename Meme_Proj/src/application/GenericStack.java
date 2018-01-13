package application;

import java.util.ArrayList;

/**
 * Creates a stack of items 
 * @author Cheyenne Sanchez
 *
 * @param <E> A generic type to include different types
 */
public class GenericStack<E> {

	/**
	 * The data of this generic ArrayList
	 */
	private ArrayList<E> data;
	
	/**
	 * Constructs a empty stack 
	 */
	public GenericStack() {
		this.data = new ArrayList<E>();
	}

	/**
	 * Determines whether the stack is empty.
	 * Precondition: None.
	 * Postcondition: Returns true if the stack is empty; otherwise returns false.
	 * @return A boolean value specifying if this stack is empty
	 */
	public int getSize() {
		return this.data.size();		
	}
	
	/**
	* Retrieves the top of a stack.
	* Precondition: None.
	* Postcondition: If the stack is not empty, the item that was added most recently is returned. 
	* The stack is unchanged.
	* @return The item that was added most recently
	*/
	public E peek() {
		return this.data.get(data.size()-1);
	}
	
	/**
	* Adds an item to the top of a stack.
	* Precondition: item is the item to be added.
	* Postcondition: If insertion is successful, item is on the top of the stack.
	* @param item The item to be added to the stack
	*/
	public void push(E item) {
		this.data.add(item);
	}
	
	/**
	* Removes the top of a stack.
	* Precondition: None.
	* Postcondition: If the stack is not empty, the item that was added most recently is removed
	* from the stack and returned.
	* @return The item that was most recently added to this stack
	*/
	public E pop() {
		return this.data.get(data.size()-1);
	}
	
	/**
	* Determines whether the stack is empty.
	* Precondition: None.
	* Postcondition: Returns true if the stack is empty; otherwise returns false.
	* @return A boolean value specifying if this stack is empty
	*/
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
}

