/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.ArrayList;

public class Arraylist extends ArrayList{
    public Arraylist toArrayList(String string)
    {
        Arraylist list= new Arraylist();
        String temp;
        
        while(!string.isEmpty())
        {
            temp=string.substring(0,1);
            list.add(temp);
            string=string.substring(1,string.length());
        }
        return list;
    }
    public String ListToString(Arraylist a)
    {
        String s="";
        for(int i=0;i<a.size();i++)
        {
            s+=a.get(i);
        }
        return s;
    }
}
