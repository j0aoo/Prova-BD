package DAO;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO extends ExecuteSQL {
    
    public ConsultaDAO(Connection con) {
    
        super(con);
    
    }
    
    public String Inserir_Consulta(Consulta a) {
        
        try{
            
            String sql = "insert into consulta values(0,?,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_cliente());
            ps.setInt(2, a.getCod_procedimento());
            ps.setString(3, a.getPreco_procedimento());
            ps.setString(4, a.getHorario());
            ps.setString(5, a.getNomeCli());
            ps.setString(6, a.getDataAtual());
            ps.setString(7, a.getDataConsulta());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        }catch(SQLException e){
        
            return e.getMessage();
        
        }
        
    }
 
    public List<Consulta> ListarConsulta() {
    
        String sql = "select idcliente,nomecli,horario,data_consulta from consulta";
        List<Consulta> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Consulta a = new Consulta();
                    a.setCod_cliente(rs.getInt(1));
                    a.setNomeCli(rs.getString(2));
                    a.setHorario(rs.getString(3));
                    a.setDataConsulta(rs.getString(4));
                
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }

    public List<Consulta> Pesquisar_Nome_Consulta(String nome) {
    
        String sql = "select idcliente,nomecli,horario,data_consulta from consulta where nomecli like '%"+ nome +"%'";
        List<Consulta> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Consulta a = new Consulta();
                    a.setCod_cliente(rs.getInt(1));
                    a.setNomeCli(rs.getString(2));
                    a.setHorario(rs.getString(3));
                    a.setDataConsulta(rs.getString(4));
                
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
    public List<Consulta> Pesquisar_Data_Consulta(String data) {
    
        String sql = "select idcliente,nomecli,horario,data_consulta from consulta where data_atual = '"+ data +"'";
        List<Consulta> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                 
                while (rs.next()) {
                    
                    Consulta a = new Consulta();
                    a.setCod_cliente(rs.getInt(1));
                    a.setNomeCli(rs.getString(2));
                    a.setHorario(rs.getString(3));
                    a.setDataConsulta(rs.getString(4));
                
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
    
    }
    
    public boolean Testar_Consulta_Agendamento(String dataConsulta, String horario) {
        
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from consulta where data_consulta = '"+ dataConsulta +"' and horario = '"+ horario +"'";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Resultado = true;
                    
                }
                
            }
            
        } catch (SQLException ex) {
        
            ex.getMessage();
        
        }
        
        return Resultado;
        
    }

    public List<Consulta> ListarComboConsulta(){
        
        String sql = "select nomecli from consulta order by nomecli";
        List<Consulta> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Consulta a = new Consulta();
                    a.setNomeCli(rs.getString(1));
                    lista.add(a);
                    
                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (Exception e) {
        
            return null;
        
        }
        
    }
 
    public List<Consulta> ConsultaInformConsulta(String nome) {
        
        String sql = "select idconsulta,horario,data_consulta from consulta where nomecli = '"+ nome +"'";
        List<Consulta> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Consulta a = new Consulta();
                    a.setCodigo(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setDataConsulta(rs.getString(3));
                    lista.add(a);

                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (Exception e) {
            
            return null;
            
        }
        
    }
    
    public String Excluir_Consulta(Consulta a){
        
        String sql = "delete from consulta where idconsulta = ?";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
                
            } else {
                
                return "Erro ao excluir";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    
}
