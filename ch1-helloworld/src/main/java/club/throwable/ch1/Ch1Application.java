package club.throwable.ch1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/31 9:33
 */
@RestController
@SpringBootApplication
public class Ch1Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineRunner.class);
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Hello SpringBoot!Current dateTime is {}", FORMATTER.format(LocalDateTime.now()));
	}

	@GetMapping(value = "/hello")
	public String sayHello(@RequestParam(value = "name") String name) {
		return "hello " + name;
	}
}