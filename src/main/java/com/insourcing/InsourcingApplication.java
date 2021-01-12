package com.insourcing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.DealCounter;

import com.insourcing.entity.RecruiterProfileEntity;
import com.insourcing.model.HRFormRequest;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.DealCounterRepo;

import com.insourcing.repository.HRLoginRepo;
import com.insourcing.services.DealsService;
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
	DealCounterRepo repo;
	@Autowired
	DealsService dealService;
	@Autowired
	TransistionService transistionService;
	private static Logger log = LogManager.getLogger(InsourcingApplication.class);
	@Autowired
	public CandidateRepo candRepo;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.driver-class-name}")
	private String driverName;
	@Value("${spring.datasource.username}")
	private String encryptedUserName;
	@Value("${spring.datasource.password}")
	private String encryptedPassword;

	@Value("${spring.mail.username}")
	private String senderUsername;
	@Value("${spring.mail.password}")
	private String senderPassword;
	@Value("${spring.mail.host}")
	private String host;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InsourcingApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(InsourcingApplication.class, args);
		log.info("Insourcing Portal started successfully");
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
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		try {
		mailSender.setHost(host);
		mailSender.setPort(587);

		mailSender.setUsername(senderUsername);
		mailSender.setPassword(senderPassword);
		} catch (Exception ex) {
			log.error(String.format("Mail sender exception %s", ex));
		}
		return mailSender;
	}

//	@Bean
//	public CommandLineRunner init(HRLoginRepo hrRepo) {
//		return args -> {
//			HRFormRequest request = new HRFormRequest("1", "test", "test@tcs.com", "test", "INDIA");
//			hrService.register(request);
//		};
//	}

@Bean
	public CommandLineRunner init(HRLoginRepo hrRepo) {
		return args -> {
			HRFormRequest request = new HRFormRequest("1", "test", "test@tcs.com", "Test@123", "INDIA");
			hrService.register(request );
			try {
				//DealCounter counter = new DealCounter();
				//counter.setName("deal_counter");
				//counter.setValue(10000);repo.save(counter);
			CandidateEntityMap map = new CandidateEntityMap();	
			map.setEmailid("mail1");map.setDealId("DL219110000");map.setOfferStatus("Joined");
			map.setFirstname("fn");map.setLastname("ln");
			CandidateEntityMap map1 = new CandidateEntityMap();	
			map1.setEmailid("mail2");map1.setDealId("DL219110001");map1.setOfferStatus("Offer_Progress");
			map1.setFirstname("fn");map1.setLastname("ln");
			CandidateEntityMap map2 = new CandidateEntityMap();	
			map2.setEmailid("mail3");map2.setDealId("DL219110002");map2.setOfferStatus("Offer_Acceptance_Pending");
			map2.setFirstname("fn");map2.setLastname("ln");
			CandidateEntityMap map3 = new CandidateEntityMap();	
			map3.setEmailid("mail4");map3.setDealId("DL3977");map3.setOfferStatus("in progress");
			map3.setFirstname("fn");map3.setLastname("ln");
			CandidateEntityMap map5 = new CandidateEntityMap();	
			map5.setEmailid("mail5");map5.setDealId("DL423");map5.setOfferStatus("Joined");
			map5.setFirstname("fn");map5.setLastname("ln");
			candRepo.save(map);
			candRepo.save(map1);
			candRepo.save(map2);
			candRepo.save(map3);
			candRepo.save(map5);

			String filter = "{\"status\":\"All\",\"client\":\"all\"}";
			transistionService.fetchRecruiterDetails(filter, "test@tcs.com");
			
			String filter1 = "{\"status\":\"All\",\"client\":\"c1\"}";
			transistionService.fetchRecruiterDetails(filter1, "test@tcs.com");
			
			//dealService.readProperties(null);
			//System.exit(0);
			Path path = Paths.get("C:/component.png");
		    byte[] data = Files.readAllBytes(path);
		    List<RecruiterProfileEntity> list = new ArrayList<RecruiterProfileEntity>();
		    RecruiterProfileEntity one = new RecruiterProfileEntity();
		    one.setId(0);
		    one.setName("someanem");
		    one.setMail("somemailo");
		    one.setImg(data);
		    one.setFileName("component.png");
		    one.setCountry("INDIA");
		    one.setContactNo("9999999");list.add(one);
		    one.setId(1);list.add(one);
		    one.setId(2);list.add(one);
		    one.setId(3);list.add(one);
		    one.setId(4);list.add(one);
		    transistionService.saveRecruiterProfile(list);
			}catch(Exception e) {
				e.printStackTrace();
			}
			//candidateService

			/*
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
			transistionService.saveCrf(crfEntity );*/
		/*	parent.put("id", 1l);
			parent.put("euApplicationForm", euApplForm.toString());
			System.out.println(parent.toString());
			CRFEntity crfEntity = objectMapper.readValue(parent.toString(), CRFEntity.class);
			*/
			/*CRFEntity crfEntity = new CRFEntity();
			
			*/			//System.out.println(euApplForm);
			//System.out.println("saving11"+objectMapper.writeValueAsString(crfEntity));
			
			/*Path path = Paths.get("c:\\code\\excel.xlsx");
			String name = "excel.xlsx";
			String originalFileName = "excel.xlsx";
			String contentType = "application/vnd.ms-excel";
			byte[] content =  Files.readAllBytes(path);
			System.out.println(content.length);
			MultipartFile result = new MockMultipartFile(name,
                    originalFileName, contentType, content);*/
			//transistionService.saveCrf(crfEntity );
			//transistionService.uploadInterviewSchedule(result, 1l);
		};
	}

}
