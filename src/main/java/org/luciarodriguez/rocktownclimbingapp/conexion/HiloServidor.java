package org.luciarodriguez.rocktownclimbingapp.conexion;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class HiloServidor extends Thread{

    private Socket socket;

    public HiloServidor(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            //Recibe del cliente el nombre nada mas conectarse
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String usuario = entrada.readLine();
            String contrasena = entrada.readLine();

            //Indicamos que se ha recibido el nombre y se ha conectado el ciente
            System.out.println("Cliente conectado: " + usuario + " - " + contrasena);

            URL url = new URL("http://localhost:8080/empleado/find-and?nombre=" + usuario + "&contrasenaHash=" + contrasena);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            //Recibe la respuesta de la petición
            int status = con.getResponseCode();

            //Respuesta del login
            if (status == 200) {
                Scanner scanner = new Scanner(con.getInputStream());
                String respuesta = scanner.nextLine();
                System.out.println("Respuesta del servidor: " + respuesta);
                //Enviarle la instrucción al servidor
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println(respuesta);
            }

            //Bucle que va recibiendo peticiones
            while (true) {
                String peticion = entrada.readLine();
                System.out.println(peticion);
                int responseCode = 0;
                HttpURLConnection peticionServidor = null;
                
                if (peticion.equals("AltaEmpleado")){
                    //Recoger los datos del usuario
                    String dni = entrada.readLine();
                    String nombre = entrada.readLine();
                    String apellidos = entrada.readLine();
                    String direccion = entrada.readLine();
                    String rol = entrada.readLine();
                    String nombreUsuario = entrada.readLine();
                    String email = entrada.readLine();
                    String contrasenaHash = entrada.readLine();

                    //Hacemos la peticion de insert
                    url = new URL("http://localhost:8080/empleado/insert");
                    peticionServidor = (HttpURLConnection) url.openConnection();
                    peticionServidor.setRequestMethod("POST");
                    //Indicamos el doOutput a true para que permita escribir los parametros en el cuerpo de la petición
                    peticionServidor.setDoOutput(true);

                    //Creamos los parametros
                    String parameters = "nombre=" + nombre +
                            "&apellidos=" + apellidos +
                            "&rol=" + rol +
                            "&dni=" + dni +
                            "&direccion=" + direccion +
                            "&nombreUsuario=" + nombreUsuario +
                            "&email=" + email +
                            "&contrasenaHash=" + contrasenaHash;

                    try (OutputStream os = peticionServidor.getOutputStream()) {
                        byte[] input = parameters.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }
                }
                else if (peticion.equals("CargarEmpleados")) {
                    url = new URL("http://localhost:8080/empleado/select-all");

                    peticionServidor = (HttpURLConnection) url.openConnection();
                    peticionServidor.setRequestMethod("GET");
                }
                else if (peticion.equals("EliminarEmpleado")) {
                    //Recoger el id del empleado a borrar
                    Long id = Long.parseLong(entrada.readLine());

                    //Hacemos la peticion de insert
                    url = new URL("http://localhost:8080/empleado/delete");
                    peticionServidor = (HttpURLConnection) url.openConnection();
                    peticionServidor.setRequestMethod("POST");

                    //Indicamos el doOutput a true para que permita escribir los parametros en el cuerpo de la petición
                    peticionServidor.setDoOutput(true);

                    //Creamos los parametros
                    String parameters = "id=" + id;

                    try (OutputStream os = peticionServidor.getOutputStream()) {
                        byte[] input = parameters.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }
                }
                else if (peticion.equals("BuscarEmpleado")) {
                    //Recoger los datos del empleado a buscar
                    String dni = entrada.readLine();
                    String apellidos = entrada.readLine();
                    String nombreUsuario = entrada.readLine();
                    url = new URL("http://localhost:8080/empleado/find-employee?dni=" + dni + "&apellidos=" + apellidos + "&nombreUsuario=" + nombreUsuario);

                    peticionServidor = (HttpURLConnection) url.openConnection();
                    peticionServidor.setRequestMethod("GET");
                }
                else if (peticion.equals("CargarRecordatorios")){
                    //Recoger el id del empleado conectado
                    Long id = Long.parseLong(entrada.readLine());

                    url = new URL("http://localhost:8080/recordatorio/find-by-emp?empleadoId=" + id);

                    peticionServidor = (HttpURLConnection) url.openConnection();
                    peticionServidor.setRequestMethod("GET");
                }

                // Leer respuesta del servidor
                responseCode = peticionServidor.getResponseCode();
                System.out.println("Código de respuesta: " + responseCode);

                //Para todas las peticiones enviamos respuesta al cliente
                if (responseCode == 200) {
                    Scanner scanner = new Scanner(peticionServidor.getInputStream());
                    if (scanner.hasNextLine()) {
                        String respuesta = scanner.nextLine();
                        System.out.println("Respuesta del servidor: " + respuesta);
                        //Enviarle la instrucción al servidor
                        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                        salida.println(respuesta);
                    }
                    else {
                        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                        salida.println("Datos vacios");
                    }
                }
            }
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }
}
