package com.example.hrady;

import com.example.hrady.data.CastleInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.PathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class HradyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HradyApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public List<CastleInfo> listAll() {

		var castles = new ArrayList<CastleInfo>();

		//Current directory: System.getProperty("user.dir");
		String dataPath= "E:\\Fotky\\Hrady";
		try {
			var dataDirContent = Files.list(Paths.get(dataPath));

			for (var file : dataDirContent.map(Path::getFileName).sorted().collect(Collectors.toList())) {
				castles.add(new CastleInfo(file.toString(), file.toString()));
			}
		}
		catch (Exception e) {

		}

		//castles.add(new CastleInfo(dataDirectory, "castle0"));
		/*castles.add(new CastleInfo("Castle1", "castle1"));
		castles.add(new CastleInfo("Castle2", "castle2"));
		castles.add(new CastleInfo("Castle3", "castle3"));
*/
		return castles;
	}
}
