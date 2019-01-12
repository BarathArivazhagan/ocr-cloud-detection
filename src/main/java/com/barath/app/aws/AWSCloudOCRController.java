package com.barath.app.aws;

import com.barath.app.aws.AWSOCRService;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Profile("aws")
@RestController(value = "/aws")
public class AWSCloudOCRController {

    private final AWSOCRService awsocrService;


    public AWSCloudOCRController( AWSOCRService awsocrService) {
        this.awsocrService = awsocrService;
    }

    @PostMapping(value = "/extractText")
    public List<String> textDetections(@RequestBody MultipartFile file){
        return this.awsocrService.extractText(file);
    }

}
