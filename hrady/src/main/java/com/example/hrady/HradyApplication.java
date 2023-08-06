package com.example.hrady;

import com.example.hrady.data.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.io.IOException;

@SpringBootApplication
@RestController
public class HradyApplication {

	private final String dataPath= "E:\\Fotky\\Hrady";

	public static void main(String[] args) {
		SpringApplication.run(HradyApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public List<CastleInfo> listAll() {

		var castles = new ArrayList<CastleInfo>();

		//Current directory: System.getProperty("user.dir");
		try {
			var dataDirContent = Files.list(Path.of(dataPath));

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
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/hrad")
	public String getShit() {
		return "shit";
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/hrad/{folder}")
	public CastleDetail getCastle(@PathVariable("folder") String folder) {

		CastleDetail result =  null;
		try {
			var dataDir = Path.of(dataPath, folder);

			List<String> dirContent = loadContent(dataDir);
			if (hasMoreImageCollections(dirContent)) {
				generateCollectionList(dirContent);
			}
			else {
				CastleLegend legend = parseLegend(dataDir);
				String note = getNote();
				result = buildCastleDetail(folder, dirContent, legend, note);
			}
		}
		catch (Exception e) {

		}

		return result;
	}

	private CastleDetail buildCastleDetail(String folder, List<String> dirContent, CastleLegend legend, String note) {

		var pictures = new ArrayList<PictureInfo>();
		for (String fileName : dirContent) {
			pictures.add(new PictureInfo(fileName, "some description"));
		}

		return new CastleDetail(folder, pictures);
	}

	private String getNote() {
		return null;
	}

	private CastleLegend parseLegend(Path dataDir) {
		return null;
	}

	private List<String> loadContent(Path directory) throws IOException {
		var directoryContent = Files.list(directory);

		var files = new ArrayList<String>();
		for (var file : directoryContent.map(Path::getFileName).sorted().collect(Collectors.toList())) {
			files.add(file.toString());
		}
		return files;
	}

	private List<String> generateCollectionList(List<String> dirContent) {
		return null;
	}

	private boolean hasMoreImageCollections(List<String> dirContent) {
		return false;
	}
}
