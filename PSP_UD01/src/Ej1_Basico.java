import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ej1_Basico {
	
	public static void main(String [] args) throws Exception {
		Utils.imprimeArgs(args);
		try {
			Process proceso = new ProcessBuilder(Utils.sh(String.join(" ", args))).start();
			
			/**
			 * INPUT STREAM :: Flujo de entrada de bytes (0's y 1's) en byte[]
			 */
			InputStream flujo_de_entrada_de_datos = proceso.getInputStream();
			InputStreamReader lector_de_flujo = new InputStreamReader(flujo_de_entrada_de_datos);
			/**
			 * BUFFERED READER se utiliza para leer el flujo de entra de proceso para devolver (String linea)
			 */
			BufferedReader br = new BufferedReader(lector_de_flujo);
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			
			
			/*Espera que finalice el Proceso*/
			int rerturn_code =proceso.waitFor();
			if(rerturn_code == 0) {
				
			}else {
				throw new Exception("El comando no es correcto");
			}
			
			System.out.println("Code:"+rerturn_code);
			

		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}