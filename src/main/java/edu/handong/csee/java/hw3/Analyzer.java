package edu.handong.csee.java.hw3;

public class Analyzer {
	
	private int numberOfCountries;
	private int sameCountrycount=0;
	private int totalPatient=0;
	private int patients_Of_A_Country;
	private int dateInNum;
	private int dateInNum2;
	private int patients_From_A_Specified_Date;
	private int patients_Before_A_Specified_Date;
	private int patients_Between_Two_Dates;
	private String[] data;
	private String[][] dataIn2DArray = new String[500][500];
	public Analyzer(String[] data) {
		this.data = data;
		TwoDsetter(this.data);
	}
	
	public void TwoDsetter(String[] data) {
		for(int i=0;i<data.length;i++) {
			dataIn2DArray[i] = data[i].split(",");
			if(data[i].charAt(0) == '"') {
				dataIn2DArray[i][0] = dataIn2DArray[i][0] + ",";
				dataIn2DArray[i][0] = dataIn2DArray[i][0].concat(dataIn2DArray[i][1]);
				dataIn2DArray[i][0] = dataIn2DArray[i][0].substring(1,dataIn2DArray[i][0].length()-1);
				for(int j=1;j<dataIn2DArray[i].length-1;j++) {
				dataIn2DArray[i][j] = dataIn2DArray[i][j+1];
				}
			}
			else if(dataIn2DArray[i][1].charAt(0) == '"') {
				dataIn2DArray[i][1] = dataIn2DArray[i][1] + ",";
				dataIn2DArray[i][1] = dataIn2DArray[i][1].concat(dataIn2DArray[i][2]);
				dataIn2DArray[i][1] = dataIn2DArray[i][1].substring(1,dataIn2DArray[i][1].length()-1);
				for(int j=2;j<dataIn2DArray[i].length-1;j++) {
				dataIn2DArray[i][j] = dataIn2DArray[i][j+1];
				}
			}
		}
	}



	public int getNumberOfCountries(){ 
		for(int i=1;i<data.length;i++) {
			numberOfCountries++;
			for(int j=1;j<i;j++) {
				
				if(dataIn2DArray[i][1].equalsIgnoreCase(dataIn2DArray[j][1])&&i!=j) {
					sameCountrycount++;
					break;
				}
			}
			if(sameCountrycount!=0) {
				numberOfCountries--;
			}
			sameCountrycount = 0;
		}
		
		return numberOfCountries;
	}
	public int getNumberOfAllPatients(){
		
		for(int i=1;i<data.length;i++) {
			int temp = Integer.parseInt(dataIn2DArray[i][dataIn2DArray[i].length-1]);
			totalPatient = totalPatient+temp;
		}
		
		
		return totalPatient;
	}
	public int getNumberOfPatientsOfACountry(String country) {
		
		for(int i=1;i<data.length;i++) {
			if(country.equalsIgnoreCase(dataIn2DArray[i][1])) {
				patients_Of_A_Country = patients_Of_A_Country + Integer.parseInt(dataIn2DArray[i][dataIn2DArray[0].length-1]);
			}
		}
		
		return patients_Of_A_Country;
	}
	public int getNumberOfPatientsFromASpecifiedDate(String date) {
		dateInNum = Util.findDate(date,dataIn2DArray);
		
		for(int j=1;j<data.length;j++) {
			patients_From_A_Specified_Date = patients_From_A_Specified_Date + Integer.parseInt(dataIn2DArray[j][dataIn2DArray[j].length-1]) - Integer.parseInt(dataIn2DArray[j][dateInNum-1]);

		}
		

		return patients_From_A_Specified_Date;
	}
	public int getNumberOfPatientsBeforeASpecifiedDate(String date) {
		dateInNum = Util.findDate(date,dataIn2DArray);

		for(int i=1;i<data.length;i++) {
			patients_Before_A_Specified_Date = patients_Before_A_Specified_Date + Integer.parseInt(dataIn2DArray[i][dateInNum-1]);
		}
		
		return patients_Before_A_Specified_Date;
		
	}
	public int getNumberOfPatientsBetweenTwoDates(String date1,String date2){
		dateInNum = Util.findDate(date1,dataIn2DArray);
		dateInNum2 = Util.findDate(date2,dataIn2DArray);
		
		for(int i=1;i<data.length;i++) {
			patients_Between_Two_Dates = patients_Between_Two_Dates + Integer.parseInt(dataIn2DArray[i][dateInNum2]) - Integer.parseInt(dataIn2DArray[i][dateInNum-1]);
		}
		
		return patients_Between_Two_Dates;
	}


	
	
	
}
