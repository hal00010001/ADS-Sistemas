//package br.com.bikes.agr.config;
//
//import java.io.IOException;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;
//
//import org.glassfish.jersey.server.ContainerRequest;
//import org.glassfish.jersey.server.ContainerResponse;
//
//public class CorsFilter implements ContainerResponseFilter {
//	
//	public ContainerResponse filter(ContainerRequest requestC, ContainerResponse responseC) {
//		
//		ResponseBuilder resBuilder = Response.fromResponse(responseC.getResponse());
//		
//		resBuilder.header("Access-Control-Allow-Origin", "*")
//					.header("API, GET, POST, PUT, DELETE, OPTIONS, HEAD, TRACE, CONNECT")
//					.header("Access-Control-Headers", "x-requested-with, Content-Type");
//		
//		String requestHeader = requestC.getHeaderValue("Access-Control-Request-Headers");
//		
//		
//		if(null != requestHeader && !requestHeader.equals(null)) {
//			resBuilder.header("Access-Control-Allow-Headers", requestHeader);
//		}
//		
//		responseC.setResponse(resBuilder.build());
//		
//		return responseC;
//		
//	}
//
//	@Override
//	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
//			throws IOException {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
