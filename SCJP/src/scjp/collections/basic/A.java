package scjp.collections.basic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author student
 */
public class A {

    public class B {
        
        public void matoda() {
                System.out.println("B.metoda");
            }

        public class C {
            
            public void matoda() {
                B.this.matoda();
                System.out.println("C.metoda");
            }
        }
    }
    
    public static void main(String[] args) {
        
        A a = new A();
        
        A.B b = a.new B();
        
        B.C c = b.new C();
        
        c.matoda();
        
    }
    
}


