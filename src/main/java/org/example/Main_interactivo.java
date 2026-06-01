package org.example;
import java.util.Scanner;

/**
 * Clase principal que permite al usuario interactuar con la máquina expendedora.
 */
public class Main_interactivo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Expendedor exp= new Expendedor(5);
        boolean activo=true;
        while(activo){
            System.out.println("INGRESE EL NUMERO DEL PRODUCTO QUE QUIERE");
            System.out.print("1.COCA COLA    "); System.out.println("2.FANTA");
            System.out.print("3.SPRITE    "); System.out.println("   4.SNICKER");
            System.out.println("5.SUPER 8");
            System.out.println("0.SALIR");
            int producto=sc.nextInt();
            if (producto==0){
                System.out.println("SALIENDO    ");
                activo=false;
                continue;
            }
            TipoProducto tipo=null;
            if (producto == 1) {
                tipo = TipoProducto.COCACOLA;
            } else if (producto == 2) {
                tipo = TipoProducto.FANTA;
            } else if (producto == 3) {
                tipo = TipoProducto.SPRITE;
            } else if (producto == 4) {
                tipo = TipoProducto.SNICKERS;
            } else if (producto == 5) {
                tipo = TipoProducto.SUPER8;
            } else {
                System.out.println("PRODUCTO INVALIDO");
                continue;
            }
            System.out.println("INGRESE MONEDA:");
            System.out.print("1.100     "); System.out.println("2.500");
            System.out.print("3.1000    "); System.out.println("4.1500");
            System.out.println("0.SALIR");
            int maquinamoneda=sc.nextInt();
            Moneda moneda=null;
            if(maquinamoneda==1){
                moneda=new Moneda100();
            }
            else if(maquinamoneda==2){
                moneda=new Moneda500();
            }
            else if(maquinamoneda==3){
                moneda=new Moneda1000();
            }
            else if(maquinamoneda==4){
                moneda=new Moneda1500();
            }
            else if(maquinamoneda==0){
                System.out.println("SALIENDO");
                activo=false;
                continue;
            }
            else {System.out.println("MONEDA INVALIDA");
                continue;}
            try {
                Comprador c = new Comprador(moneda, tipo, exp);

                System.out.println("tomaste: " + c.queBebiste());
                System.out.println("tu vuelto es: " + c.cuantoVuelto());

            } catch (PagoIncorrectoException e) {
                System.out.println(e.getMessage());

            } catch (PagoInsuficienteException e) {
                System.out.println(e.getMessage());

            } catch (NoHayProductoException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }

        }
        sc.close();
    }
}