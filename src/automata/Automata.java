
package automata;

import java.util.Scanner;

/**
 *
 * @author BURGOS
 */
public class Automata {
  //  static final int ERROR = -1;
    //    static final int ACEPTAR =0;
      int cont;
       static char[] car;
       String patronnum = "[0-9]";
       String patronletras = "[a-z]";
       String patronsimbolos = "[-+=]";
       String expresion ;
       
              
    public static void main(String[] args) {
        Automata aut= new Automata();
        String cad = "asdfrr*ee6print";
        aut.car =cad.toCharArray();
        aut.begin();     
    }

    public void begin() {
        cont=0;
        estado_0();
    }
    public void estado_0(){
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(!expresion.matches(patronnum) && !expresion.matches(patronletras) && !expresion.matches(patronsimbolos)){
                System.out.println("Caracter invalido, no pertenece al alfabeto de este automata");
                return;
            }
            else if(car[cont]== 'p'){
                System.out.println("En estado 0 y para estado 8 con "+car[cont]);
                cont++;
                estado_8();
            }else if(car[cont] == '+'){
                System.out.println("En estado 0 con "+car[cont]);
                System.out.println("SUMAR");
                cont++;
                //return;
            
                
            }else if(expresion.matches(patronnum)){
                System.out.println("En estado 0 y para estado 4 con "+car[cont]);
                cont++;
                estado_4();
            }else if(car[cont]== '-'){
                cont++;
                System.out.println("RESTAR");
                //return;
            }else if(car[cont]== '='){
                cont++;
                System.out.println("ASIGNAR");
                //return;
            }else if(car[cont]!= 'p'){
               System.out.println("En estado 0 y para estado 6 con"+car[cont]);
                cont++;
                estado_6();
            }else{
                System.out.println("Caracter no encontrado en el alfabeto de este automata...");
            }
        }
    }
    
    public void estado_8() {
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(car[cont]=='r'){
                System.out.println("En estado 8 y para estado 9 con "+car[cont]);
                cont++;
                estado_9();
            }else if(expresion.matches(patronnum) || expresion.matches(patronsimbolos)){
                System.out.println("LETRAS -- Estado_13 " + car[cont]);
                estado_0();
                //estado_13();
            }else if(car[cont]!= 'r'){
                System.out.println("En estado 8 y para estado 6 con "+car[cont]);
                cont++;
                estado_6();
            }
        }
    }

    public void estado_9() {
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(car[cont]=='i'){
                System.out.println("En estado 9 y para estado 10 con "+car[cont]);
                cont++;
                estado_10();
            }else if(expresion.matches(patronnum) || expresion.matches(patronsimbolos)){
                
                System.out.println("LETRAS -- Estado_13 " + car[cont]);
                estado_0();
                //estado_13();
            }else if(car[cont]!='r'){
                System.out.println("En estado 9 y para estado 6 con "+car[cont]);
                cont++;
                estado_6();
                
            }
        }
    }

    public void estado_10() {
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(car[cont]=='n'){
                System.out.println("En estado 10 y para estado 11 con "+car[cont]);
                cont++;
                estado_11();
            }else if(expresion.matches(patronnum) || expresion.matches(patronsimbolos)){
                System.out.println("LETRAS -- Estado_13" + car[cont]);
                estado_0();
                //estado_13();
            }else if(car[cont]!='n'){
                System.out.println("En estado 10 y para estado 6 con "+car[cont]);
                cont++;
                estado_6();
            }
        }
    
    }

    public void estado_11() {
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(car[cont]=='t'){
                System.out.println("En estado 11 y para estado de aceptacion con "+car[cont]);
                cont++;
                estado_12();
            }else if(expresion.matches(patronnum) || expresion.matches(patronsimbolos)){
                System.out.println("LETRAS -- Estado_13" + car[cont]);
                //estado_13();
                estado_0();
            }else if(car[cont]!='t'){
                System.out.println("En estado 11 y para estado 6 con "+car[cont]);
                cont++;
                estado_6();
            }
        }
    }

    public void estado_12() {
        System.out.println("Palabra aceptada");
    }
    
    public void estado_6(){
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(expresion.matches(patronletras)){
                System.out.println("En estado 6 y para estado 6 con "+car[cont]);
                cont++;
                estado_6();
            }else{
                System.out.println("LETRAS -- Estado 7 con " + car[cont]);
                estado_0();
                
            }
        }
    }
    
    public void estado_4(){
        if(cont<car.length){
            expresion=String.valueOf(car[cont]);
            if(expresion.matches(patronnum)){
                System.out.println("En estado 4 y para estado 4 con "+car[cont]);
                cont++;
                estado_4();
            }else{
                System.out.println("ENTERO -- En estado 5 con " + car[cont]);
                estado_0();        
            }
        }
    }
    
    /*public void estado_13(){
            estado_0();
    }*/
    
    
}
