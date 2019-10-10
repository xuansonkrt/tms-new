package application.config;

public class ServerCustomize  {

}


/*
 * @Configuration
 * 
 * public class ServerCustomize extends ServerProperties {
 * 
 * @Override
 * public void customize(ConfigurableEmbeddedServletContainer container) {
 * super.customize(container);
 * container.addErrorPages(
 * new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/layouts/error-404.jsp"),
 * new ErrorPage(HttpStatus.BAD_REQUEST, "/WEB-INF/layouts/error-500.jsp"),
 * new ErrorPage("/error")
 * );
 * }
 * }
 */