
package practica1;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Practica1 {

 
 
 static String registro [][] = new String [20][2];
//    static String registro [][] = {{"banana","20"},{"cafe","10"},{"carne","10"},{"pollo","16"},{"fresas","4"},{"tortrix","2"},{"quiesifritos","20"},{"manzana","5"},{"papaya","8"},{"leche","25"},{"nesquick","13"},{"coca cola","6"},{"tampico","5"},{"chetos","7"},{"pera","3"},{"zanahoria","3"},{"perejil","12"},{"pizza","5"},{"cafe","5"},{"arroz","2"}};
 static int indice  = 0;
 static int indice2 = 0;
 static String cuponesm [][] = new String [20][2];
 static String carritocomp[][] = new String [20][6];
static String cantidadv [][] = new String [20][2];
static int indice3= 0;
static int subtotal2=0;
static    String empresa = "SUPER-25";
static    String cajero = "Pedro";
static Double descuentoQ =0.00;
static int cantidadmodi = 0;


 
// static String matriz[][] = new String[3][3];
    public static void main(String[] args) {//verificador de inicio de sesion
  String u = "cajero_202004730";
  String p = "ipc1_202004730";
  String usuario;
  String contra;
  
  //lectura de los datos de la consola
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese usuario");
        usuario=entrada.nextLine();
        System.out.println("Ingrese contrasena");
        contra=entrada.nextLine();
        
//        if(u.equals(usuario)){//verificacion de usuario y contrasena
//            if(p.equals(contra)){
//                System.out.println("Bienvenido al cajero!");
//                mostratmenu();
//            }else{
//                System.out.println("La contrasena es incorrecta!");
//            }
//        }else{
//            System.out.println("El usuario es invalido!");
//        }   
    while(!u.equals(usuario) || !p.equals(contra)){//verificacion de usuario y contrasena
        System.out.println("Los datos son errones, verifique de nuevo porfavor.");
        System.out.println("Ingrese usuario");
        usuario=entrada.nextLine();
        System.out.println("Ingrese contrasena");
        contra=entrada.nextLine();
    }    
    if(u.equals(usuario) && p.equals(contra)){
  System.out.println("Bienvenido al cajero!");
  mostrarmenu();
}
        
    }
            
public static void mostrarmenu(){
    String opcion="";
//    int opcion = 0;
    boolean salir = false;
                       
    while(!salir || opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4")){
        System.out.println("1. Agregar nuevos productos");
    System.out.println("2. Agregar cupones de descuento");
    System.out.println("3. Realizar ventas");
    System.out.println("4. Realizar reportes");
    System.out.println("5. Salir");
    
    Scanner entrada = new Scanner(System.in);
    System.out.println("Porfavor digite la opcion");
//    opcion = entrada.nextInt();
opcion = entrada.nextLine();
    
    switch (opcion) {//condiciones segund el valor indicado y desplegar los submenus
            case "1":
                agregarproductos();
                break;
            case "2":
                agregarcupones();
                break;
            case "3":
                datosventas();
                break;
            case "4":
                mostrarproven();
//                matrizreporte();
                break;
            case "5":
                salir=true;
                break;
            default:
            System.out.println("Opcion invalida");                   
            break;
    }                       
    }
           
}        
public static void agregarproductos(){
    if (indice<20) { //condicion para verificar que se mantenga menor a 20 productos
    String nombre;
    String precio;
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese el nombre del producto");
    nombre= entrada.nextLine();
    while(buscar(nombre)){//condicion para reconocer que no existan productos repetidos
        System.out.println("El producto ingresado ya existe");
        System.out.println("Ingrese el nombre del producto");   
        nombre= entrada.nextLine();
    }
    System.out.println("Ingrese el precio del producto");   
    precio=entrada.nextLine();
    
    
    while(precio.equals("0")){//condicion para que no exista un producto con valor 0
        System.out.println("El precio debe ser mayor a 0!");
        System.out.println("Ingrese el precio del producto");   
        precio=entrada.nextLine();
    }
        if (!precio.equals("0")) {// si es diferente de 0, agregar la informacion
    registro[indice] [0]=nombre;
    cantidadv[indice][0]=nombre;
    cantidadv[indice][1]="0";
    registro[indice][1]=precio;
    System.out.println("Informacion almacenada ");
    System.out.println(registro[indice] [0]+" Q."+registro[indice][1]);
   
    indice = indice+1;
        }
    

}else{
        System.out.println("No hay mas espacio para almacenar datos");
    }


}

 public static void mostrarproductos(){
        for(int fila=0; fila<20; fila++){
            
                System.out.print(registro[fila][0]+" Q." + registro[fila][1] ); 
                System.out.println("");
        }

    }

public static boolean buscar(String nombre){
    for (int fila = 0; fila < 20; fila++) {
        //para que no explote solo tenemos que revisar que no sea null antes de compararlo
        if((registro[fila][0]!=null))
            if(registro[fila][0].equals(nombre))
                return true;
    }
    return false;
}
public static boolean buscarcodigo(String codigo){
    for (int fila = 0; fila < 20; fila++) {
        //para que no explote solo tenemos que revisar que no sea null antes de compararlo
        if((cuponesm[fila][0]!=null))
            if(cuponesm[fila][0].equals(codigo))
                return true;            
    }
    return false;
}


public static void agregarcupones(){
    int veriint;
    if (indice2<20) { //condicion para verificar que se mantenga menor a 20 codigos
    String codigo;
    String descuento;
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese codigo del cupon");
    codigo= entrada.nextLine();
    while(codigo.length()!=4){//condicion para reconocer que es de 4 caracteres
        System.out.println("El cupon debe ser de 4 caracteres");
        System.out.println("Ingrese codigo del cupon");   
        codigo= entrada.nextLine();
    }
//    System.out.println("Ingrese codigo del cupon");   
//    codigo=entrada.nextLine();
    while(buscarcodigo(codigo)){//condicion para reconocer que no existan cupones repetidos
        System.out.println("El cupon ingresado ya existe");
        System.out.println("Ingrese codigo del cupon");   
        codigo= entrada.nextLine();
    }
    System.out.println("Ingrese el descuento del producto en %");   
    descuento=entrada.nextLine();
    while((veriint = parseInt(descuento))==0 || (veriint = parseInt(descuento))>100){//condicion para que no exista un descuento con valor 0 y mayor que 100
        //descuento.equals("0") || devolverpor(codigo)>100
        System.out.println("El codigo debe ser mayor al 0 y menor a 100!");
        System.out.println("Ingrese el descuento del producto en %");   
        descuento=entrada.nextLine();

    }
        if (veriint!=0 || veriint<=100) {// si es diferente de 0, agregar la informacion
    cuponesm[indice2] [0]=codigo;
    cuponesm[indice2][1]=descuento;
    System.out.println("Informacion almacenada ");
    System.out.println(cuponesm[indice2] [0]+" "+cuponesm[indice2][1] + "%");
   
    indice2 = indice2+1;
        }
     

}else{
        System.out.println("No hay mas espacio para almacenar datos");
    }


}

public static int devolverpor(String codigo){
    for (int fila = 0; fila < 20; fila++) { 
        // para que no explote
        if((cuponesm[fila][0]!=null))
            if(cuponesm[fila][0].equals(codigo))
                return parseInt(cuponesm[fila][1]);            
    }
    return -1;
}

public static void datosventas(){
    if (indice3<20) {
    String cliente;
    String Nit;
    String nombre;
    String cantidad;
    String precio;
    String Subtotal;
    double total;
//    int continuar=0;
    String continuar= "";
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese el nombre del cliente");
    cliente= entrada.nextLine();
    System.out.println("Ingrese el numero de NIT, si no lo utilizara escriba C/F");
    Nit= entrada.nextLine();
    
    
    
    do{
    System.out.println("Listado de productos:");
    mostrarproductos();
    System.out.println("Ingrese el nombre del producto a comprar");
    nombre= entrada.nextLine();
    while(productocarrito(nombre) || !validadorproducto(nombre)){//condicion para validar que el producto ya esta en el carrito
        System.out.println("El producto ya ha sido anadido al carrito o no existe, por favor verifique los datos ingresados");
        System.out.println("Ingrese el nombre del producto a comprar");   
        nombre= entrada.nextLine();    
    }
       
    precio = Integer.toString(devolverprecio(nombre));
    System.out.println("Ingrese la cantidad a comprar");
    cantidad= entrada.nextLine();
    
    Subtotal = Integer.toString(devolverprecio(nombre)*parseInt(cantidad));
    
    carrito(cliente, Nit, nombre, precio, cantidad, Subtotal);
    //aqui ingresar el metodo
    cantidadmodi=devolvercantidad(nombre);
    modificar(nombre);
    System.out.println("producto en el carrito de compras ");
    System.out.println("Producto: " + carritocomp[indice3] [2]+" Cantidad:"+carritocomp[indice3][4]);
    indice3 = indice3 + 1;
            System.out.println("Desea ingresar otro producto?");
            System.out.println("0 Si");
            System.out.println("Cualquier otro caracter: No");
            continuar = entrada.nextLine();

    }while(continuar.equals("0") && indice3<20);
    mostrarventa();
    calculosubtotal();
    System.out.println("El total de la compra es de Q."+subtotal2);
    descuentocod();
    System.out.println("Porfavor ingrese la fecha de hoy: ");
    String fecha = entrada.nextLine();
    System.out.println("Factura de compra ");
    System.out.println("Nombre de la empresa: "+empresa);
    System.out.println("Nombre del cajero: " + cajero);
    System.out.println("Nombre del cliente: " + cliente);
    System.out.println("Numero de Nit: " + Nit);
    System.out.println("Fecha de emision de la factura: " + fecha);
    System.out.println("Listado de productos: "  );
    listado();
    System.out.println("Subtotal: Q." + subtotal2);
    System.out.println("Porcentaje de descuento(si aplica): " + descuentoQ*100 +"%");//parseDouble(descuentoQ)
    total = subtotal2-descuentoQ*subtotal2;//parseDouble(descuentoQ)
    System.out.println("Total: Q." + total );
    limpiarmatriz();
    indice3=0;
    subtotal2=0;
    descuentoQ =0.00;
//    mostrarventa();
//    matrizreporte();
    }else{
        System.out.println("No hay mas espacio para almacenar datos");
    }
}
public static void carrito(String cliente, String Nit, String nombre, String precio, String cantidad, String Subtotal){
    carritocomp[indice3] [0]= cliente;
    carritocomp[indice3][1]=Nit;
    carritocomp[indice3] [2]= nombre;
//    cantidadv[indice3][0]=nombre;
    carritocomp[indice3][3]=precio;
    carritocomp[indice3] [4]= cantidad;
//    cantidadv[indice3][1]=cantidad;
    carritocomp[indice3] [5]= Subtotal;
}    

public static int devolverprecio(String nombre){
    for (int fila = 0; fila < 20; fila++) { 
        // para que no explote
        if((registro[fila][0]!=null))
            if(registro[fila][0].equals(nombre))
                return parseInt(registro[fila][1]);            
    }
    return -1;
}

public static void mostrarventa(){
    for (int fila = 0; fila < 20; fila++) {
//        for (int col = 0; col < 6; col++) {
            System.out.print("Cliente: "+carritocomp[fila][0]+" Nit: " + carritocomp[fila][1] +" Producto: " + carritocomp[fila][2] +" Precio: " + carritocomp[fila][3] +" Cantidad: " + carritocomp[fila][4] + " Subtotal: " + carritocomp[fila][5]);           
//        }
        System.out.println("");       
    }
}
 
public static void descuentocod(){
    String respuesta;
    String codigo;
//    String descuentoQ;
//    int subtotal2=0;
    Scanner entrada = new Scanner(System.in);
    System.out.println("Cuenta con un codigo de descuento?");
    System.out.println("0 Si");
    System.out.println("1 No");
    respuesta= entrada.nextLine();
    if (respuesta.equals("0")) {
    System.out.println("Ingrese el codigo de descuento");    
    codigo= entrada.nextLine();
    while(!validadordecodigo(codigo)){//condicion para reconocer que no existan productos repetidos
        System.out.println("El codigo de descuento no fue encontrado, porfavor verifique");
        System.out.println("Ingrese el codigo de descuento");   
        codigo= entrada.nextLine();    
    }
    descuentoQ = devolverdescuento(codigo)*0.01;//= Double.toString((devolverdescuento(codigo)*0.01));
//        System.out.println("Descuento:" + descuentoQ);
        
    }
    
}
public static boolean validadordecodigo(String codigo){
    for (int fila = 0; fila < 20; fila++) {
        //para que no explote solo tenemos que revisar que no sea null antes de compararlo
        if((cuponesm[fila][0]!=null))
            if(cuponesm[fila][0].equals(codigo))
                return true;
    }
    return false;
}

public static int devolverdescuento(String codigo){
    for (int fila = 0; fila < 20; fila++) { 
        // para que no explote
        if((cuponesm[fila][0]!=null))
            if(cuponesm[fila][0].equals(codigo))
                return parseInt(cuponesm[fila][1]);            
    }
    return -1;
}
public static void calculosubtotal(){
    
    for (int fila = 0; fila < 20; fila++) {
        if((carritocomp[fila][0]!=null))
            subtotal2 = subtotal2 + parseInt(carritocomp[fila][5]);
    }
}


public static void listado(){
    for (int fila = 0; fila < 20; fila++) {
//        for (int col = 0; col < 6; col++) {
            System.out.print(" Producto: " + carritocomp[fila][2] +" Precio unitario: " + carritocomp[fila][3] +" Cantidad adquirida: " + carritocomp[fila][4] + " Subtotal: " + carritocomp[fila][5]);           
//        }
        System.out.println("");       
    }
}

public static boolean validadorproducto(String nombre){
    for (int fila = 0; fila < 20; fila++) {
        //para que no explote solo tenemos que revisar que no sea null antes de compararlo
        if((registro[fila][0]!=null))
            if(registro[fila][0].equals(nombre))
                return true;
    }
    return false;
}

 public static void mostrarproven(){
  
     for(int pasada1=0; pasada1<20; pasada1++){  
//         if ((cantidadv[pasada1][0]!=null)) {
            for(int pasada2=0; pasada2<19; pasada2++){  
                
                    
               
                    String[] filaTemporal = new String[20];
                    int cantidad1 = parseInt(cantidadv[pasada2][1]);
                    int cantidad2 = parseInt(cantidadv[pasada2+1][1]);                    
                    // si la fila actual tiene menos ventas que la fila siguiente se van a intercambiar
                    if(cantidad1<cantidad2){
                        filaTemporal[0]=cantidadv[pasada2+1][0];
                        filaTemporal[1]=cantidadv[pasada2+1][1];

                        cantidadv[pasada2+1][0]=cantidadv[pasada2][0];
                        cantidadv[pasada2+1][1]=cantidadv[pasada2][1];

                       
                        cantidadv[pasada2][0]=filaTemporal[0];
                        cantidadv[pasada2][1]=filaTemporal[1];


                    }
            }
//        }
         }
        System.out.println("");
//        System.out.println("Matriz ordenada descendentemente");
        matrizreporte();

    }

 public static void matrizreporte(){
    for(int fila=0; fila<20; fila++){            
                System.out.print("Producto: "+cantidadv[fila][0]+" Cantidad de veces comprado: " + cantidadv[fila][1] ); 
                System.out.println("");
        } 
 }
 public static void limpiarmatriz(){
     for (int fila = 0; fila < 20; fila++) {
         for (int col = 0; col <6; col++) {
            carritocomp[fila][col] = null;
         }       
     }    
 }
 
 public static boolean productocarrito(String nombre){
     for (int fila = 0; fila < 20; fila++) {
        //para que no explote solo tenemos que revisar que no sea null antes de compararlo
        if((carritocomp[fila][0]!=null))
            if(carritocomp[fila][2].equals(nombre))
                return true;
    }
    return false;
 }
 
 public static void reportecantidad(){
     for (int fila = 0; fila < 20; fila++) {
         if (cantidadv[fila][0].equals(carritocomp[fila][2])) {
             cantidadv[fila][1]= cantidadv[fila][1] + carritocomp[fila][4];
         }
     }
 }
 
 public static int devolvercantidad(String nombre){
    for (int fila = 0; fila < 20; fila++) { 
        // para que no explote
        if((carritocomp[fila][0]!=null))
            if(carritocomp[fila][2].equals(nombre))
                return parseInt(carritocomp[fila][4]);            
    }
    return -1;
}

 public static void modificar(String nombre){
     int actual = 0;
    for (int fila = 0; fila < 20; fila++) { 
        // para que no explote
        if((cantidadv[fila][0]!=null))
            if(cantidadv[fila][0].equals(nombre)){
                actual = parseInt(cantidadv[fila][1]);
                actual= actual + cantidadmodi;
                cantidadv[fila][1] = actual +"";}
//                break;
                         
    }
}
}
    


            

