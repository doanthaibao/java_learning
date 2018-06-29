package com.bao.doan.example;
/*User interface contains two types of user input controls: TextInput, which accepts all characters and NumericInput, which accepts only digits.

Implement the class TextInput that contains:

Public method void add(char c) - adds the given character to the current value
Public method String getValue() - returns the current value
Implement the class NumericInput that:

Inherits from TextInput
Overrides the add method so that each non-numeric character is ignored
For example, the following code should output "10":

TextInput input = new NumericInput();
input.add('1');
input.add('a');
input.add('0');
System.out.println(input.getValue());
DifficultyEasy 
Time15min*/
public class UserInput {

	public static class TextInput {
		StringBuffer input = new StringBuffer();

		public void add(char c) {
			input.append(c);
		}

		public String getValue() {
			return input.toString();
		}
	}

	public static class NumericInput extends TextInput {
		@Override
		public void add(char c) {
			try {
				Integer.parseInt(String.valueOf(c));
				input.append(c);
			} catch (Exception e) {
				// Do nothing
			}
		}
	}

	public static void main(String[] args) {
		 TextInput input = new NumericInput();
		 input.add('1');
		 input.add('a');
		 input.add('0');
		 System.out.println(input.getValue());
	}
}