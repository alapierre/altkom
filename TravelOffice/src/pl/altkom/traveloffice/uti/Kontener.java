/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice.uti;

import java.util.Iterator;

/**
 *
 * @author altkom
 */
public class Kontener<T> implements Iterable<T>{
    
    private int currentSize = 10;
    private Object[] tab = new Object[currentSize];
    private int licznik = 0;
    
    public void add(T liczba) {
        incraseTabSizeIfNessesery();
        tab[licznik++] = liczba;
    }

    private void incraseTabSizeIfNessesery() {
        if(licznik == currentSize) {
            currentSize *=2;
            Object[] tmp = new Object[currentSize];
            System.arraycopy(tab, 0, tmp, 0, tab.length);
            tab = tmp;
        }
    }
    
    public T get(int index) {
        return (T)tab[index];
    }
    
    public void set(int index, T value) {
        tab[index] = value;
    }
    
    public static void main(String[] args) {
        Kontener<Integer> kontener = new Kontener<Integer>();
        
        for(int i = 0; i<100; i++)
            kontener.add(i);
        
        System.out.println(kontener);
        
        //kontener.set(7, "ala ma kota");
        
        int res = (int)kontener.get(7);
        System.out.println(res);
    }
    
    public String toString() {
        String res = "";
        for(Object i : tab) {            
            if(i!=null)
                res += i+ ", ";
        }
        
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new KontenerIterator<>(this);
    }
    
    public class KontenerIterator<T> implements Iterator<T> {

        private Kontener<T> kontener;
        private int counter; 

        public KontenerIterator(Kontener<T> kontener) {
            this.kontener = kontener;
        }
        
        @Override
        public boolean hasNext() {
            return kontener.licznik < counter;
        }

        @Override
        public T next() {
            return (T)kontener.tab[counter++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
