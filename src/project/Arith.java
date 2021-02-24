/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author Ahmed
 */
public class Arith {
    String input=new String();
    List <String> Uni=new ArrayList();
    List <range> UniR=new ArrayList();
    Arraylist data=new Arraylist();
    Arraylist a1=new Arraylist();
    double low=0,high=1,lower,higher,code,temp;
    int count=0;
    public void range(String s)
    {
        data=data.toArrayList(s);
        unique(data);
        for (int x=0;x<Uni.size();x++)
        { 
            UniR.add(new range(low+(double)(Collections.frequency(data, Uni.get(x))/(double)data.size()),low,Uni.get(x)));
            low=UniR.get(x).high;
            System.out.println(UniR.get(x).high+","+UniR.get(x).low+","+UniR.get(x).s);
       
        }
    }
    public void unique(Arraylist a)
    {
        for(int i=0;i<a.size();i++)
            if(Uni.indexOf(a.get(i).toString())==-1){
                Uni.add(a.get(i).toString());
            }
        System.out.println(Uni);
        Collections.sort(Uni);
        System.out.println(Uni);
    }
    double compress(String s)
    {
        if(s.isEmpty())
        {
            return Double.NaN;
        }
        else
        {
            range(s);
        low=0;
        while (!s.isEmpty())
        {
            input=s.substring(0, 1);
            for (int i=0;i<UniR.size();i++)
                if(UniR.get(i).s.equals(input))
                {
                    lower=UniR.get(i).low;
                    higher=UniR.get(i).high;
                    break;
                }
            temp=low;
            low=low+lower*(high-low);
            high=temp+higher*(high-temp);
            System.out.println("low: "+low+"    high: "+high);
            count++;
            s=s.substring(1);
        }
        if(high==low)
            code=low;
        else
            code=ThreadLocalRandom.current().nextDouble(low, high);
        System.out.println("code: "+code);
        System.out.println("Uni: "+Uni+" data: "+data);
        for(int i=0;i<UniR.size();i++)
            System.out.println("UniR: "+UniR.get(i).s);
        return code;
        }
    }
    String Decompress(double code)
    {
        a1.clear();
        low=0;
        high=1;
       for (int i=0;i<count;i++)
        {
           double code2=(code-low)/(high-low);
           for (int c=0;c<UniR.size();c++)
           {
               System.out.println("high: "+UniR.get(c).high+" low: "+UniR.get(c).low);
           }
           for(int x=0;x<UniR.size();x++)
            {
                if(code2<UniR.get(x).high&&code2>UniR.get(x).low)
                {
                    a1.add(UniR.get(x).s);
                    System.out.println(a1);
                    temp=low;
                    low=low+(UniR.get(x).low*(high-low));
                    high=temp+(UniR.get(x).high*(high-temp));
                    
                }
            }
        }
        UniR.clear();
        Uni.clear();
        data.clear();
        String out;
        out=a1.ListToString(a1);
        count=0;
        low=0;
        high=1;
        System.out.println(out);
       return out;
    }
}
