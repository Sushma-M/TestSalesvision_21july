/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;

/**
 * Service object for domain model class FollowUps.
 * @see com.salesdb.FollowUps
 */

public interface FollowUpsService {
   /**
	 * Creates a new followups.
	 * 
	 * @param created
	 *            The information of the created followups.
	 * @return The created followups.
	 */
	public FollowUps create(FollowUps created);

	/**
	 * Deletes a followups.
	 * 
	 * @param followupsId
	 *            The id of the deleted followups.
	 * @return The deleted followups.
	 * @throws EntityNotFoundException
	 *             if no followups is found with the given id.
	 */
	public FollowUps delete(Integer followupsId) throws EntityNotFoundException;

	/**
	 * Finds all followupss.
	 * 
	 * @return A list of followupss.
	 */
	public Page<FollowUps> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<FollowUps> findAll(Pageable pageable);
	
	/**
	 * Finds followups by id.
	 * 
	 * @param id
	 *            The id of the wanted followups.
	 * @return The found followups. If no followups is found, this method returns
	 *         null.
	 */
	public FollowUps findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a followups.
	 * 
	 * @param updated
	 *            The information of the updated followups.
	 * @return The updated followups.
	 * @throws EntityNotFoundException
	 *             if no followups is found with given id.
	 */
	public FollowUps update(FollowUps updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the followupss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the followups.
	 */

	public long countAll();


    public Page<FollowUps> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

