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

/**
 *
 * @author Brian
 */
public class SpeedDiagnostic {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
        /*Process exec;  
        try {  
            exec = Runtime.getRuntime().exec("ipconfig");  
            if ( exec.waitFor() == 0)  
                System.out.println("Executado.");  
            else  
                System.out.println("ERRO");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }*//*

  try {
    // Use a ProcessBuilder
    ProcessBuilder pb = new ProcessBuilder("ping 158.69.55.227");

    Process p = pb.start();
    InputStream is = p.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    int r = p.waitFor(); // Let the process finish.
    if (r == 0) { // No error
       // run cmd2.
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
        
    }
    
}*/
        
  public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			// reading output stream of the command
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		String ip = "vivas.eng.br";
		runSystemCommand("ping -t " + ip);

	
	}
}

