package com.insourcing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.model.HRFormRequest;
import com.insourcing.repository.HRLoginRepo;
import com.insourcing.services.HRService;
import com.insourcing.services.TransistionService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
@ComponentScan(basePackages = { "com.insourcing" })
@Configuration
public class InsourcingApplication extends SpringBootServletInitializer {
	
	@Autowired
	HRService hrService;
	@Autowired
	TransistionService transistionService;
	private static Logger log = LogManager.getLogger(InsourcingApplication.class);
		
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.driver-class-name}")
	private String driverName;
	@Value("${spring.datasource.username}")
	private String encryptedUserName;
	@Value("${spring.datasource.password}")
	private String encryptedPassword;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InsourcingApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InsourcingApplication.class, args);
		log.info("Insourcing Portal started successfully");
		//DealsService ds=context.getBean(DealsService.class);
		//ds.upload();
	}

	@Primary
	@Bean
	public DataSource customDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName(driverName);
			dataSource.setUrl(url);
			dataSource.setUsername(encryptedUserName);
			dataSource.setPassword(encryptedPassword);
		} catch (Exception ex) {
			log.error(String.format("DB connection exception %s", ex));
		}
		return dataSource;
	}
	
	@Bean
	public CommandLineRunner init(HRLoginRepo hrRepo) {
		return args -> {
			HRFormRequest request = new HRFormRequest("1", "test", "test@tcs.com", "test", "INDIA");
			hrService.register(request );
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode parent = objectMapper.createObjectNode();
			ObjectNode euStatusMangement = objectMapper.createObjectNode();
			ObjectNode euApplForm = objectMapper.createObjectNode();
			ObjectNode noneuStatusMaangement = objectMapper.createObjectNode();
			ObjectNode noneuApplForm = objectMapper.createObjectNode();
			euStatusMangement = updatePref(euStatusMangement);
			euApplForm = updatePref(euApplForm);
			noneuStatusMaangement = updatePref(noneuStatusMaangement);
			noneuApplForm = updatePref(noneuApplForm);
			CRFEntity crfEntity = objectMapper.readValue(parent.toString(), CRFEntity.class);
			crfEntity.setId(1L);
			crfEntity.setEuApplicationForm(euApplForm.toString());
			crfEntity.setEuStatusManagement(euStatusMangement.toString());
			crfEntity.setNoneuApplicationForm(noneuApplForm.toString());
			crfEntity.setNoneuStatusManagement(noneuStatusMaangement.toString());
			System.out.println("saving11"+objectMapper.writeValueAsString(crfEntity));
			transistionService.saveCrf(crfEntity );
		/*	parent.put("id", 1l);
			parent.put("euApplicationForm", euApplForm.toString());
			System.out.println(parent.toString());
			CRFEntity crfEntity = objectMapper.readValue(parent.toString(), CRFEntity.class);
			*/
			/*CRFEntity crfEntity = new CRFEntity();
			
			*/			//System.out.println(euApplForm);
			//System.out.println("saving11"+objectMapper.writeValueAsString(crfEntity));
			
			Path path = Paths.get("c:\\code\\excel.xlsx");
			String name = "excel.xlsx";
			String originalFileName = "excel.xlsx";
			String contentType = "application/vnd.ms-excel";
			byte[] content =  Files.readAllBytes(path);
			System.out.println(content.length);
			MultipartFile result = new MockMultipartFile(name,
                    originalFileName, contentType, content);
			transistionService.saveCrf(crfEntity );
			transistionService.uploadInterviewSchedule(result, 1l);
			
		};
	}
	
	public ObjectNode updatePref(ObjectNode json) {
		json.put("fn", false);
		json.put("mn", false);
		json.put("ln", false);
		json.put("cn", false);
		json.put("skills", false);
		json.put("ct", false);
		json.put("dob", false);
		json.put("loc", false);
		json.put("pwd", false);
		json.put("confpwd", false);
		return json;
	}

}