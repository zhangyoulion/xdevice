package com.xxx.it.xdevice.api.service;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/deviceservice")
@Produces(MediaType.APPLICATION_JSON)
public interface IDeviceApiService {

	@GET
	@Path("/list/{page}/{pageSize}")
	public Map findList(@PathParam("page") int page, @PathParam("pageSize") int pageSize);
}