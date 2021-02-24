/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Ahmed Abdelaziz
 */
public class LZ78Tupel {
    
    int index;
    String next_char;
    
    public LZ78Tupel( int index, String next_char ){
        this.index = index;
        this.next_char = next_char;
    }
    
    public LZ78Tupel( String next_char ){
        this.next_char = next_char;
    } 
    
    public int getIndex(){
        return index;
    }
    
    public String getString(){
        return next_char;
    }  

    
}
