package com.redball.dao.impl;

import com.redball.dao.SqlConnectorDeleteLater;
import com.redball.dao.CityDao;
import com.redball.entity.CityEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultCityDao implements CityDao {
    private static final String GET_ALL_CITY = "SELECT * FROM city";

    @Override
    public List<CityEntity> getAll() {
        try {
            Connection connection = SqlConnectorDeleteLater.getConnection();
            ResultSet cityResultSet = getCityResultSet(connection);
            return getCityFromDB(cityResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getCityResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_CITY);
        }
    }

    private CityEntity getCityEntity(ResultSet resultSet) throws SQLException {
        CityEntity cityEntity = new CityEntity();

        cityEntity.setId(resultSet.getInt(CityEntity.ID_COLUMN));
        cityEntity.setName(resultSet.getString(CityEntity.NAME_COLUMN));

        return cityEntity;
    }

    private List<CityEntity> getCityFromDB(ResultSet resultSet) throws SQLException {
        List<CityEntity> cities = new ArrayList<>();
        while (resultSet.next()) {
            CityEntity cityEntity = getCityEntity(resultSet);
            cities.add(cityEntity);
        }
        return cities;
    }
}
