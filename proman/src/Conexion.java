import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private Connection conexionBD;
	private boolean conectado;
	private String usuario;
	private String password;
	
	public Conexion(String usu,String pass){
		conectado=false;
		usuario=usu;
	    password=pass;
	    conexionBD=null;
	}
	
	public void desconectarBD()
	   {		
	      if (this.conexionBD != null)
	      {
	         try
	         {
	            this.conexionBD.close();
	            this.conexionBD = null;
	         }
	         catch (SQLException ex)
	         {
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	         }
	      }
	   }
	
	public void conectarBD() throws SQLException{
		
		if(conexionBD==null){
			
			try
			{
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        }catch (Exception ex){
	        	System.out.println(ex.getMessage()+" error try conectar de conex");
	        }
	   
	         
	        String servidor = "localhost:3306";
	        String baseDatos = "proyecto";
	        
	        
	        String uriConexion = "jdbc:mysql://" + servidor + "/" + baseDatos;
	   
	        this.conexionBD = DriverManager.getConnection(uriConexion, usuario, password);
	        conectado=true;
         
		}
	}
	
	public Statement statement(){
		try {
			return conexionBD.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean conectado(){
		return conectado;
	}
}

