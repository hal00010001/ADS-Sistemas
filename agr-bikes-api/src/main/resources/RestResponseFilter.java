//import javax.ws.rs.container.ContainerResponseFilter;
//
//@Provider
//public class RestResponseFilter implements ContainerResponseFilter {
//
//	@Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException{
//        
//		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
//        responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
//        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept");
//        
//    }
//	
//}
