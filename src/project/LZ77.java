/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class LZ77 {

   public List<LZ77Tupel> compress( String text )
        {
                text = text.replace(System.getProperty("line.separator"), "");
                List<LZ77Tupel> list = new ArrayList<LZ77Tupel>();
                String search = "";
                String input = text;

                String next;
                int indexGood = 0;
                int indexFound;
                int searchLen;

                while ( input.length() > 0 )
                {
                        searchLen = 1;
                        next = input.substring( 0, searchLen );
                        if ( search.indexOf( next ) == -1 )
                        {
                                list.add( new LZ77Tupel(0,0, next ) );
                                System.out.println("taaag "+"0"+"0"+next);
                                search += next;
                                System.out.println("this is search area  "+search);
                                input = input.substring( searchLen );
                               // searchLen++;
                                continue;
                        }
                        do
                        {
                                if(searchLen>input.length()){break;}
                                next = input.substring( 0, searchLen );
                                System.out.println("this is next "+next);
                                indexFound = search.indexOf( next );
                                System.out.println("this is found "+indexFound);
                                if ( indexFound != -1 )
                                        indexGood =search.length()- indexFound;
                                searchLen++;
                                System.out.println("search len now "+searchLen);
                        }
                        while ( indexFound != -1 );
                        search += next.substring( 0, next.length() );
                        System.out.println("Search area "+search);
                        input = input.substring( next.length() );
                        list.add( new LZ77Tupel( indexGood, next.length() - 1, next.substring( next.length() - 1 ) ) );
                       //System.out.println("taaag "+indexGood+(next.length()- 1)+next.substring(( ,next.length()- 1))+"This is a tag");
                }
                 for (LZ77Tupel s : list){
System.out.println("this is list "+list.indexOf(s));
                        }
                 for(int i=0;i<list.size();i++)
                     System.out.println(list.get(i).index+","+list.get(i).length+","+list.get(i).s);
                return list;
                
         }
   public void  decompress( List<LZ77Tupel> LZ)
           
   {
       int counter=0,pointer=0,k=0;
       ArrayList<String> Text=new ArrayList();
       String x="";
       while(counter<LZ.size())
       {
           if (LZ.get(counter).index==0)
           {
                Text.add(LZ.get(counter).s);
           }
           else
           {
              x=""; 
              k=Text.size()-LZ.get(counter).index; 
              pointer=0; 
              for (pointer=0; pointer<LZ.get(counter).length;pointer++){ 
             
                  Text.add(Text.get(k)); 
                  k++;
              }
              // Text.add(x); 
               Text.add(LZ.get(counter).s); 
           }
           counter++;
       }
       for (int i=0;i<Text.size();i++)
           System.out.print(Text.get(i));
       System.out.print("\n");
       
       
   }
   

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Get file
              /*  BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( "resources/text1.txt" ) ) );
                StringBuffer content = new StringBuffer();
                String line;
                while ( ( line = br.readLine() ) != null )
                        content.append( line );
                String message1 = content.toString();

                System.out.println( "Message1: " + message1.length() + " characters." );
                // System.out.println("Message2: " + message2.length() +
                // " characters.");*/

                LZ77 lz77 = new LZ77();

                List<LZ77Tupel> list1 = lz77.compress( "abbabb" );
                // List<LZ77Tupel> list2 = lz77.compress(message2);

                System.out.println( "Compressed1: " + list1.size() + " tupels." );
                lz77.decompress(list1);
               
                // System.out.println("Compressed2: " + list2.size() + " tupels.");

              //  System.out.println( lz77.decompress( list1 ) );
                // System.out.println(lz77.decompress(list2));

    }
}
