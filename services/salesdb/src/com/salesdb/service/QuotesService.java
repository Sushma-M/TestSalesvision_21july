/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;

/**
 * Service object for domain model class Quotes.
 * @see com.salesdb.Quotes
 */

public interface QuotesService {
   /**
	 * Creates a new quotes.
	 * 
	 * @param created
	 *            The information of the created quotes.
	 * @return The created quotes.
	 */
	public Quotes create(Quotes created);

	/**
	 * Deletes a quotes.
	 * 
	 * @param quotesId
	 *            The id of the deleted quotes.
	 * @return The deleted quotes.
	 * @throws EntityNotFoundException
	 *             if no quotes is found with the given id.
	 */
	public Quotes delete(Integer quotesId) throws EntityNotFoundException;

	/**
	 * Finds all quotess.
	 * 
	 * @return A list of quotess.
	 */
	public Page<Quotes> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Quotes> findAll(Pageable pageable);
	
	/**
	 * Finds quotes by id.
	 * 
	 * @param id
	 *            The id of the wanted quotes.
	 * @return The found quotes. If no quotes is found, this method returns
	 *         null.
	 */
	public Quotes findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a quotes.
	 * 
	 * @param updated
	 *            The information of the updated quotes.
	 * @return The updated quotes.
	 * @throws EntityNotFoundException
	 *             if no quotes is found with given id.
	 */
	public Quotes update(Quotes updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the quotess in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the quotes.
	 */

	public long countAll();


    public Page<Quotes> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

