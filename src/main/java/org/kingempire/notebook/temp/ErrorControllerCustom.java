//package org.kingempire.notebook.exceptionHandler;
//
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.WebRequest;
//
///**
// *
// * @author Anurag Singh
// */
//@RestController
//public class ErrorControllerCustom implements ErrorController {
//
//    private static final String PATH = "/error";
//
//    @Value("${error.debug:false}")
//    private boolean debug;
//
//    @Autowired
//    private ErrorAttributes errorAttributes;
//
//    @RequestMapping(value = PATH)
//    public ErrorJson error(HttpServletRequest request, WebRequest webRequest, HttpServletResponse response) {
//        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring. Here we just define response body.
//        return new ErrorJson(response.getStatus(), getErrorAttributes(request, webRequest, debug));
//    }
//
//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }
//
//    private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest, boolean includeStackTrace) {
//        return errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
//    }
//}
