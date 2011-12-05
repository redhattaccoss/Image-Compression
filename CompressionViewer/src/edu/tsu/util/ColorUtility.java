package edu.tsu.util;

public class ColorUtility {

	public String getHexadecimal(int red, int green, int blue) {
		double temp = 0;
		String hexValue = "";
		for (int i = 1; i <= 3; i++) {
			if (temp == 1) {
				temp = red;
			} else if (temp == 2) {
				temp = green;
			} else if (temp == 3) {
				temp = blue;
			}
			double divideResult = temp / 16;
			String stringDevideResult = Double.toString(divideResult);
			int pointIndexInString = stringDevideResult.indexOf(".");
			String firstValue = stringDevideResult.substring(0,
					pointIndexInString);
			double multiplySixteen = (divideResult - (Double
					.parseDouble(firstValue))) * 16;
			String stringMultiplySixteen = Double.toString(multiplySixteen);
			pointIndexInString = stringMultiplySixteen.indexOf(".");
			String secondValue = stringMultiplySixteen.substring(0,
					pointIndexInString);
			if (firstValue.equalsIgnoreCase("10")) {
				firstValue = "A";
			}else if (firstValue.equalsIgnoreCase("11")) {
				firstValue = "B";
			}else if (firstValue.equalsIgnoreCase("12")) {
				firstValue = "C";
			}else if (firstValue.equalsIgnoreCase("13")) {
				firstValue = "D";
			}else if (firstValue.equalsIgnoreCase("14")) {
				firstValue = "E";
			}else if (firstValue.equalsIgnoreCase("15")) {
				firstValue = "F";
			}
			if (secondValue.equalsIgnoreCase("10")) {
				secondValue = "A";
			}else if (secondValue.equalsIgnoreCase("11")) {
				secondValue = "B";
			}else if (secondValue.equalsIgnoreCase("12")) {
				secondValue = "C";
			}else if (secondValue.equalsIgnoreCase("13")) {
				secondValue = "D";
			}else if (secondValue.equalsIgnoreCase("14")) {
				secondValue = "E";
			}else if (secondValue.equalsIgnoreCase("15")) {
				secondValue = "F";
			}
			hexValue = hexValue + firstValue + secondValue;
		}
		return hexValue;
	}
}
