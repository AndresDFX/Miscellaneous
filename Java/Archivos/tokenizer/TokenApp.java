/*
 *Ejemplo de uso de StringTokenizer
 */

package tokenizer;



import java.util.StringTokenizer;

public class TokenApp {
     
    StringTokenizer tokens;
    
    public void pruebaTexto(){
        System.out.println("------------Texto con delimitador por defecto-----------------------");
        String nombre="Angel Franco García";
	tokens=new StringTokenizer(nombre);
        
        while(tokens.hasMoreTokens()){
            System.out.println(tokens.nextToken());
        }
    }
    
    public void pruebaDelimita(){
        System.out.println("------------------ Delimitadores---------------------------");
    //	    String strDatos="6.3\n6.2\n6.4\n6.2";
//	    tokens=new StringTokenizer(strDatos, "\n");
            String strDatos="6.3, 6.2, 6.4, 6.2";
	    tokens=new StringTokenizer(strDatos, ",");
            int nDatos=tokens.countTokens();
            System.out.println("cantidad de Tokens en el String: "+nDatos);
            
            double[] datos=new double[nDatos];
            int i=0;
            while(tokens.hasMoreTokens()){
                String str=tokens.nextToken();
                datos[i]=Double.valueOf(str).doubleValue();
                System.out.println(datos[i]);
                i++;
        }
    
    }

    public void variosDelimita(){
        System.out.println("-------------Varios Delimitadores---------------------------");
        String strDatos="1=6.3\n2=6.2\n3=6.4\n4=6.2";
        tokens = new StringTokenizer(strDatos, "=\n");
        int nDatos=tokens.countTokens();
        System.out.println("cantidad "+nDatos);
        
        String salida="Datos en la matriz\n";
        double datos[][] = new double[nDatos][nDatos];
        for (int i = 0; i < nDatos/2; i++) {
            for (int j = 0; j < 2; j++) {
                datos[i][j] = Double.parseDouble(tokens.nextToken());
                salida+=datos[i][j]+"\t";
            }
            salida+="\n";
        }
        System.out.println(salida);
    }

    public static void main(String[] args) {
        TokenApp obt = new TokenApp();
        obt.pruebaTexto();
        obt.pruebaDelimita();
        obt.variosDelimita();
	    
        try  {
            //espera la pulsación de una tecla y luego RETORNO
            System.in.read();
        }catch (Exception e) {  }
    }
}
