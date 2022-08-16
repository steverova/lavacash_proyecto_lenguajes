package com.lavacash.app;

import com.lavacash.app.upload.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {
	public static void main(String[] args) {
		
		Utils.createFolder();
		Utils.copyDirectory();
		SpringApplication.run(AppApplication.class, args);
	}
}
