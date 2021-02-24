/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Ahmed
 */
public class LZ77Tupel {
   public int             index;
        int             length;
        String  s;

        public LZ77Tupel( int index, int length, String s )
        {
                this.index = index;
                this.length = length;
                this.s = s;
        }

        public LZ77Tupel( String s )
        {
                this.s = s;
        }

        public int getIndex()
        {
                return index;
        }

        public int getLength()
        {
                return length;
        }

        public String getString()
        {
                return s;
        }

    
}
