package com.gp.ipomanager;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@Import({MyConfig.class})

@SpringBootApplication(scanBasePackages = { "com.gp.cmarket",
		"com.gp.ipomanager"/* ,"com.gp.cmarket.iporepositories","com.gp.cmarket.ipoentities" */})// allows using controllers in different packages ?
public class IPOManagerApplication {
private static ConfigurableApplicationContext context;

	
	public static void main(String[] args) throws Exception {
    	
    	
        startapp(args);

    }
	
	/**
	 * gp: this method works
	 */
	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
//            context = SpringApplication.run(WebApplication.class, args.getSourceArgs());
//            gp
            startapp(args.getSourceArgs());
        });
        thread.setDaemon(false);
        thread.start();
    }
		
	
	/**
	 * gp
	 * @param args
	 */
	private static void startapp(String[] args) {
		try {
	        context=SpringApplication.run(IPOManagerApplication.class, args);
	        
	    	}catch(RuntimeException e) {
//	    		e.printStackTrace();
	    		if(e.getClass().getName().contains("SilentExitException")) {
//	                LOGGER.debug("Spring is restarting the main thread - See spring-boot-devtools");
	            } else {
//	                LOGGER.error("Application crashed!", e);
	            	throw e;
	            }
	    		
	    		
	    	}
	}
}
