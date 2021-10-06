/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

/**
 *
 * @author Rubén
 */
public class VariablesConexion
{
    public static final String URLBD = "jdbc:postgresql://localhost:5432/tiendavideo";
    public static final String USUARIODB = "postgres";
    public static final String CONTRASENADB = "1993";
    
    public static final int CINTA_LIBRE = 1;
    public static final int CINTA_PRESTADA = 2;
    public static final int CINTA_DANIADA = 2;
    public static final int CINTA_PERDIDA = 2;
    
    public static final String CABEZA_CLIENTE_PRESTAMO = "Cliente: ";
    public static final String CREDITO_CLIENTE_PRESTAMO = "; Crédito: ";
}