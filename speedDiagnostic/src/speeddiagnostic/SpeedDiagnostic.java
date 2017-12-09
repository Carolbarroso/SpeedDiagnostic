/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speeddiagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class SpeedDiagnostic {

   
  public static void writeInFile(String[] result) throws IOException{
      
      String line[];
      try (FileWriter arq = new FileWriter("/home/natan/Desktop/teste.txt")) {
          PrintWriter gravarArq = new PrintWriter(arq);
          for(int i=1;i<result.length;i++){
              
              if(i==result.length-3 || i==result.length-4){
                  
              }else{
                  try{
                       line=result[i].split("time=")[1].split(" ms");
                        gravarArq.println(line[0]);
                  }
                  catch(Exception e){
                      gravarArq.println(result[i]);
                  }
                  
                 
              }
              
          }
          
      }
 
    
  }
      
  
  
  public static String[] runSystemCommand(String command,String packagesCounter) {
                int packagesCounterInt=Integer.parseInt(packagesCounter);
                String result[]= new String[packagesCounterInt+5];
            
		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			// reading output stream of the command
                        for(int i=0;i<result.length;i++){
                            s = inputStream.readLine();
                            result[i]=s;
                        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
            return result;
	}

	public static void main(String[] args) throws IOException {
		
		String ipOrURL = "vivas.eng.br";
                String packagesCounter = "4";
		String result[]=runSystemCommand("ping -c " + packagesCounter +" " + ipOrURL,packagesCounter);
              //  System.out.println(Arrays.toString(result));
              SpeedDiagnostic.writeInFile(result);
	}
}

