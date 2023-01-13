package com.service.soap.repository;

import com.service.soap.bandas.Bandas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class BandasRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Map<Integer, Bandas> bandasMap = new HashMap<>();

    public Bandas findById(int id) {
        return bandasMap.get(id);
    }

    @PostConstruct
    public void init(){
        selecciona_todas();
    }

    public List<Bandas> selecciona_todas() {
        return jdbcTemplate.query("SELECT * FROM banda",
                (rs, rowNum) -> mapTobandas(rs));
    }

    public String insertaBanda(Bandas banda) {
        String sql = "INSERT INTO banda (id,nombre,genero,pais) VALUES("+banda.getId()+",'"+banda.getNombre()+"','"+banda.getGenero()+"','"+banda.getPais()+"')";
        int respuesta=jdbcTemplate.update(sql);
        if(respuesta>0){
            return "Se insertó correctamente";
        }
        return "No se insertó la banda";
    }

    public String deleteByID(int id) {
        int respuesta= jdbcTemplate.update("DELETE from banda where id="+id);
        if(respuesta>0){
            return "Se eliminó correctamente";
        }
        return "No se eliminó la banda";
    }

    public String updateBanda(Bandas banda) {
        int respuesta = jdbcTemplate.update("UPDATE banda SET nombre=?, genero=?, pais=? WHERE id = ?", banda.getNombre(), banda.getGenero(), banda.getPais(), banda.getId());
        if(respuesta>0){
            return "Se actualizó correctamente";
        }
        return "No se actualizó la banda";
    }
    private Bandas mapTobandas(ResultSet resultSet) throws SQLException{
        Bandas banda= new Bandas();
        banda.setId(resultSet.getInt("id"));
        banda.setNombre( resultSet.getString("nombre"));
        banda.setGenero(resultSet.getString("genero"));
        banda.setPais(resultSet.getString("pais"));
        bandasMap.put(banda.getId(),banda);
        return banda;
    }
}
