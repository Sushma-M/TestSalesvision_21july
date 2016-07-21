/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.salesdb.service.ChannelsService;
import com.salesdb.service.RepsService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.salesdb.*;
import com.salesdb.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Channels.
 * @see com.salesdb.Channels
 */
@RestController(value = "Salesdb.ChannelsController")
@RequestMapping("/salesdb/Channels")
@Api(description = "Exposes APIs to work with Channels resource.", value = "ChannelsController")
public class ChannelsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelsController.class);

    @Autowired
    @Qualifier("salesdb.ChannelsService")
    private ChannelsService channelsService;

    @Autowired
    @Qualifier("salesdb.RepsService")
    private RepsService repsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Channels instances matching the search criteria.")
    public Page<Channels> findChannelss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Channelss list");
        return channelsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Channels instances.")
    public Page<Channels> getChannelss(Pageable pageable) {
        LOGGER.debug("Rendering Channelss list");
        return channelsService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/repses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the repses instance associated with the given id.")
    public Page<Reps> findAssociatedrepses(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated repses");
        return repsService.findAssociatedValues(id, "channels", "id", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setChannelsService(ChannelsService service) {
        this.channelsService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Channels instance.")
    public Channels createChannels(@RequestBody Channels instance) {
        LOGGER.debug("Create Channels with information: {}", instance);
        instance = channelsService.create(instance);
        LOGGER.debug("Created Channels with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Channels instances.")
    public Long countAllChannelss() {
        LOGGER.debug("counting Channelss");
        Long count = channelsService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Channels instance associated with the given id.")
    public Channels getChannels(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Channels with id: {}", id);
        Channels instance = channelsService.findById(id);
        LOGGER.debug("Channels details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Channels instance associated with the given id.")
    public Channels editChannels(@PathVariable(value = "id") Integer id, @RequestBody Channels instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Channels with id: {}", instance.getId());
        instance.setId(id);
        instance = channelsService.update(instance);
        LOGGER.debug("Channels details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Channels instance associated with the given id.")
    public boolean deleteChannels(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Channels with id: {}", id);
        Channels deleted = channelsService.delete(id);
        return deleted != null;
    }
}