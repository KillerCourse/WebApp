package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.LanguageDao;
import com.redball.entity.LanguageEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultLanguageDao implements LanguageDao {
    private static final String GET_ALL_LANGUAGES = "SELECT FROM * language";

    @Override
    public List<LanguageEntity> getAll() {
        try {
            Connection firstConnection = SqlConnector.getConnection();
            ResultSet languageResultSet = getLanguageResultSet(firstConnection);
            return getLanguageEntityFromDB(languageResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getLanguageResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_LANGUAGES);
        }
    }

    private LanguageEntity getLanguageEntity(ResultSet resultSet) throws SQLException {
        LanguageEntity languageEntity = new LanguageEntity();

        languageEntity.setId(resultSet.getInt(LanguageEntity.ID_COLUMN));
        languageEntity.setName(resultSet.getString(LanguageEntity.NAME_COLUMN));
        languageEntity.setShortName(resultSet.getString(LanguageEntity.SHORT_NAME_COLUMN));

        return languageEntity;
    }

    private List<LanguageEntity> getLanguageEntityFromDB(ResultSet resultSet) throws SQLException {
        List<LanguageEntity> languages = new ArrayList<>();
        while (resultSet.next()) {
            LanguageEntity languageEntity = getLanguageEntity(resultSet);
            languages.add(languageEntity);
        }
        return languages;
    }
}
