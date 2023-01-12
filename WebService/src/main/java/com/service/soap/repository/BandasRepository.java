package com.service.soap.repository;

import com.service.soap.bandas.Bandas;
import org.apache.commons.logging.Log;
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
        try {
            findAll();
        }
        catch (Exception es){

        }
    }

    public List<Bandas> findAll() {
        return jdbcTemplate.query("SELECT * FROM banda",
                (rs, rowNum) -> mapTobandas(rs));
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
