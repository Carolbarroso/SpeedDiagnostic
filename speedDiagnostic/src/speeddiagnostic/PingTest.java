/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speeddiagnostic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Natan
 */
public class PingTest {

    private static String ipOrURL;
    private static Integer packagesCounter;
    private static ArrayList<PingResult> resultList;
    private static Integer divideX; 

    public static void set(String ipOrURL, Integer packagesCounter, Integer divideX) {
        PingTest.ipOrURL = ipOrURL;
        PingTest.packagesCounter = packagesCounter;
        PingTest.divideX=divideX;
        PingTest.resultList = new ArrayList<>();
    }

    public static String getIpOrURL() {
        return ipOrURL;
    }

    public static Integer getPackagesCounter() {
        return packagesCounter;
    }

    public static Integer getDivideX() {
        return divideX;
    }

    private static String[] fullResult() {

        String command = "ping -c " + packagesCounter.toString() + " " + ipOrURL;

        String result[] = new String[packagesCounter + 5];

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            for (int i = 0; i < result.length; i++) {
                s = inputStream.readLine();
                result[i] = s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<PingResult> resultTreatment() {
        String result[] = PingTest.fullResult();
        String time=" ";
        String icmp= " ";
        for (int i = 1; i < result.length-4; i++) {

                try {
                    icmp = result[i].split("=")[1].split(" ")[0];
                    time = result[i].split("time=")[1].split(" ms")[0];
                } catch (Exception e) {
                    time="0";
                } finally {
                    PingResult ping = new PingResult(Integer.parseInt(icmp), Double.parseDouble(time));
                    PingTest.resultList.add(ping);
                }

            
        }
        return PingTest.resultList;
    }

}
