package com.example.sc1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SC1 {

    public static void main(String[] args) throws IOException {

        URL url;
        BufferedReader br;
        String line;
        InputStream is = null;

        System.out.print("Please enter the email handle:");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();

        String tempurl = "https://www.ecs.soton.ac.uk/people/" + email;
        System.out.println(tempurl);


        try{
            url = new URL(tempurl);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                if(line.contains("property=\"name\"")){
                    String[] parts = line.split("property=\"name\">");
                    line = parts[1];
                    String result = line.split("<")[0];
                    System.out.println("Name: " + result);

                }
            }

        }catch (MalformedURLException mue){
            mue.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally{
            try{
                if (is !=null) {
                    is.close();
                }
            }catch (IOException ioe){

            }
        }
    }
}
