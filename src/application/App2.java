package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class App2 {

	public static void main(String[] args) {
		System.out.println("App2");
		String pathString = "test.bin";
		
		try(var os = new ObjectInputStream(new FileInputStream(pathString))) {
			Person p = (Person)os.readObject();
			
			System.out.println(p);
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot open file: " + pathString);
		}
		catch(IOException e) {
			System.out.println("Cannot read file: " + pathString);
		} catch (ClassNotFoundException e) {
			/*thrown if we try to read an object that is not 
			 * available in our program
			 */
			System.out.println("Cannot read object from file: " + pathString);
		}
	}

}
