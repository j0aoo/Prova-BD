package DAO;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcedimentoDAO extends ExecuteSQL {
    
    public ProcedimentoDAO(Connection con) {
    
        super(con);
    
    }
    
    public String Inserir_Procedimento(Procedimento a) {
     
        try {
            
            String sql = "insert into procedimento values(0,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }    
    
    public List<Procedimento> ListarProcedimento() {
    
        String sql = "select cod,nome,preco from procedimento";
        List<Procedimento> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                
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
    
    public List<Procedimento> Pesquisar_Nome_Procedimento(String nome) {
    
        String sql = "select cod,nome,preco from procedimento where nome like '%"+ nome +"%'";
        List<Procedimento> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                
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
    
    public List<Procedimento> Pesquisar_Cod_Procedimento(int cod) {
    
        String sql = "select cod,nome,preco from procedimento where cod = "+ cod +"";
        List<Procedimento> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                
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
    
    public List<Procedimento> ListarComboProcedimento(){
        
        String sql = "select nome from procedimento order by nome";
        List<Procedimento> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setNome(rs.getString(1));
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

    
    public List<Procedimento> ConsultaCodigoProcedimento(String nome) {
        
        String sql = "select cod from procedimento where nome = '"+ nome +"'";
        List<Procedimento> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setCodigo(rs.getInt(1));
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
    
    public List<Procedimento> ConsultaPrecoProcedimento(String nome) {
        
        String sql = "select preco from procedimento where nome = '"+ nome +"'";
        List<Procedimento> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    a.setPreco(rs.getDouble(1));
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
    
    public String Excluir_Pocedimento(Procedimento a){
        
        String sql = "delete from procedimento where cod = ? and nome = ?";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
                
            } else {
                
                return "Erro ao excluir";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }

    public boolean Testar_Procedimento(int cod) {
        
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from procedimento where cod = "+ cod +"";
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
    
    public List<Procedimento> CapturarProcedimento(int cod){
        
        String sql = "select * from procedimento where cod = "+ cod +"";
        List<Procedimento> lista = new ArrayList<>();
        
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Procedimento a = new Procedimento();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                    
                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
            
    }
    
    public String Alterar_Procedimento(Procedimento a) {
        
        String sql = "update procedimento set nome = ? ,preco = ? where cod = ? ";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            ps.setInt(3, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                
                return "Atualizado com sucesso!";
                
            } else {
                
                return "Erro ao Atualizar!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
