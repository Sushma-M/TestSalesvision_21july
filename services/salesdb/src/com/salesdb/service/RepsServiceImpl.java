/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;


/**
 * ServiceImpl object for domain model class Reps.
 * @see com.salesdb.Reps
 */
@Service("salesdb.RepsService")
public class RepsServiceImpl implements RepsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(RepsServiceImpl.class);

    @Autowired
    @Qualifier("salesdb.RepsDao")
    private WMGenericDao<Reps, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Reps, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "salesdbTransactionManager")
     public Page<Reps> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public Reps create(Reps reps) {
        LOGGER.debug("Creating a new reps with information: {}" , reps);
        return this.wmGenericDao.create(reps);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public Reps delete(Integer repsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting reps with id: {}" , repsId);
        Reps deleted = this.wmGenericDao.findById(repsId);
        if (deleted == null) {
            LOGGER.debug("No reps found with id: {}" , repsId);
            throw new EntityNotFoundException(String.valueOf(repsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Reps> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all repss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Reps> findAll(Pageable pageable) {
        LOGGER.debug("Finding all repss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Reps findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding reps by id: {}" , id);
        Reps reps=this.wmGenericDao.findById(id);
        if(reps==null){
            LOGGER.debug("No reps found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return reps;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public Reps update(Reps updated) throws EntityNotFoundException {
        LOGGER.debug("Updating reps with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


