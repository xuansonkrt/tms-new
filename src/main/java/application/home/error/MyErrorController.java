package application.home.error;

public class MyErrorController  {
 
}
/*
 * @RestController
 * public class MyErrorController implements ErrorController {
 * 
 * @Override
 * public String getErrorPath() {
 * return "/error";
 * }
 * 
 * @RequestMapping(value = "/error")
 * Object error(HttpServletRequest request, HttpServletResponse response) {
 * Map<String, String> err = new HashMap<>();
 * err.put("my", "custom error");
 * return err;
 * }
 * }
 */