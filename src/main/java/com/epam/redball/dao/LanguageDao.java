package com.epam.redball.dao;

import com.epam.redball.entity.LanguageEntity;

import java.util.List;

/**
 * provides methods to work with languages.
 */
public interface LanguageDao {
    /**
     * Gets languages from database.
     *
     * @return list of languages if found, otherwise returns null;
     */
    List<LanguageEntity> getAll();
}
