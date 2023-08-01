package com.example.hrady;

import com.example.hrady.data.CastleInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HradyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HradyApplication.class, args);
	}

	@GetMapping("/")
	public List<CastleInfo> listAll() {
		var castles = new ArrayList<CastleInfo>();
		castles.add(new CastleInfo("Castle1", "castle1"));
		castles.add(new CastleInfo("Castle2", "castle2"));
		castles.add(new CastleInfo("Castle3", "castle3"));

		return castles;
	}
}
