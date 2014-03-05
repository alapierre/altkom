/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections.basic;

/**
 *
 * @author student
 */
public class StaticInnerClassTest{ 
    
    private int i;
    
    public static class InnerClass {
        public void method() {
            System.out.println("InnerClass.method");
            
            StaticInnerClassTest t = new StaticInnerClassTest();
            t.i = 2;
        }
    }
    
    public static void main(String[] args) {
        StaticInnerClassTest.InnerClass i = new StaticInnerClassTest.InnerClass();
    }
    
}
