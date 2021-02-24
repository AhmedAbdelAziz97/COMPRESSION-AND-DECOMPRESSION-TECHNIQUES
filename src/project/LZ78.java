/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed Abdelaziz
 */
public class LZ78 {

    public List<LZ78Tupel> compress( String text ){
        text = text.replace(System.getProperty("line.separator"), "");
        List<LZ78Tupel> list = new ArrayList<LZ78Tupel>();
        
        ArrayList<String> search=new ArrayList();
       
        search.add(null);
        String input = text;
        String next;
        
        int indexGood = 0;
        int indexFound;
        int searchLen;
        
        while ( input.length() > 0 ){
            searchLen = 1;
            next = input.substring( 0, searchLen );
            
            if ( search.indexOf( next ) == -1 ){
                 list.add( new LZ78Tupel(0, next ) );
                 System.out.println("TAG "+"0"+next);
                 search.add(next);
                 System.out.println("this is search area  "+search);
                 input = input.substring( searchLen );
                 continue;
             }
             do{
                 next = input.substring( 0, searchLen );
                 System.out.println("this is next "+next);
                 indexFound = search.indexOf( next );
                 System.out.println("this is found "+indexFound);
                 
                 if ( indexFound != -1 )
                     indexGood = indexFound;
                     
                     if(searchLen<input.length())
                         searchLen++;
                     else
                     {
                         searchLen=0;
                         break;
                     }
                     System.out.println("search len now "+searchLen);
                }
                 while ( indexFound != -1 );
                 search.add(next.substring( 0, next.length() ));
                 System.out.println("Search area "+search);
                 input = input.substring( next.length() );
                 if((indexFound!=-1)&&(searchLen==input.length()))
                     list.add( new LZ78Tupel( indexGood, null ) );
                 else
                     list.add( new LZ78Tupel( indexGood, next.substring( next.length() - 1 ) ) );
                 System.out.println("taaag "+indexGood+(next.length()- 1)+next.substring(( next.length()- 1))+"This is a tag");
        }
        for (LZ78Tupel next_char : list){
            System.out.println("this is list "+list.indexOf(next_char));
        }
        System.out.println(search);
    return list;
    }
    
            

    public static void main(String[] args) {
        
        LZ78 lz78 = new LZ78();
        
        List<LZ78Tupel> list1 = lz78.compress( "ABBBAA" );
        
        System.out.println( "Compressed1: " + list1.size() + " tupels." );
        for (int i=0;i<list1.size();i++)
        {
            System.out.println("<"+list1.get(i).index+","+list1.get(i).next_char+">");
        }
        
    }
    
}
