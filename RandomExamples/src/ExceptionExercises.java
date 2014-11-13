/* Answers to Exercises
---
Is the following code legal?
try {    
} finally {
}
Yes, try{}finally{} is legal
----
What exception types can be caught by the following handler?
catch (Exception e) {
}
What is wrong with using this type of exception handler?

Any exception type can be caught (assuming it extends Exception as it should).
However this doesn't inform the user of what the issue could be, only that one occurred
----
Is there anything wrong with the following exception handler as written?
Will this code compile?
try {
} catch (Exception e) {
} catch (ArithmeticException a) {
}

The code will not compile because the second catch statement will never be reached.
The first catch statement already catches all instances that could be caught by the second.
----
Match the situations with their errors
1. b is an error
2. d is a checked exception
3. a is a compile error
4. c is no exception
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ExceptionExercises {
	public static void main(String[] args) {
		
	}
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    	finally {
	    }
	        if (input != null) {
	            try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
	class ListOfNumbers {
		private List<Integer> list;
		private static final int SIZE = 10;
		
		public ListOfNumbers() {
			list = new ArrayList<Integer>(SIZE);
			for (int i = 0; i < SIZE; i++)
				list.add(new Integer(i));
		}
		
		public void readList() {
			
		}
		
		public void writeList() {
			PrintWriter out = null;

			try {
				System.out.println("Entering try statement");
				out = new PrintWriter(new FileWriter("OutFile.txt"));

				for(int i = 0; i < SIZE; i++) {
					out.println("Value at: " + i + " = " + list.get(i));
				}
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Caught IndexOutOfBoundsException: "
						+ e.getMessage());
			} catch (IOException e) {
				System.err.println("Caught IOException: " + e.getMessage());
			} finally {
				if (out != null) {
					System.out.println("Closing PrintWriter");
					out.close();
				} else {
					System.out.println("PrintWriter not open");
				}
			}
		}

	public void method1() {
		try {

		} finally {

		}
	}

	public void method3() {
		try {

		} catch (Exception e) {

		}
		// catch (ArithmeticException a) {}
	}
}
