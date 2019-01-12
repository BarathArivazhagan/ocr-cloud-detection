package com.barath.app.azure;


import com.barath.app.azure.AzureOCRImageResponse;
import com.barath.app.azure.Line;
import com.barath.app.azure.Region;
import com.barath.app.azure.Word;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Profile("azure")
@RestController
public class AzureCloudOCRController {


    private static final String V1_OCR_URI="/vision/v1.0/ocr";
    private static final String V2_OCR_URI="/vision/v2.0/ocr";
    private static final String V1_RECOGNIZETEXT_URI="/vision/v1.0/recognizeText?handwriting=true";

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${azure.endpoint.url}")
    private String computeVisionAPI;

    @Value("${azure.subscription.id}")
    private String azureKey;


    public AzureCloudOCRController() {
    }

    @PostMapping("/azure/v1/ocr")
    public Map<String,Object> extractOCRVersion1(@RequestBody @NotNull  MultipartFile file, @RequestParam("language") String language) throws Exception{
        return extratOCRFromImage(this.computeVisionAPI.concat(V1_OCR_URI),file,language);

    }

    @PostMapping("/azure/v1/recognizeText")
    public Map<String,Object> recognizeTextVersion1(@RequestBody @NotNull  MultipartFile file, @RequestParam("language") String language) throws Exception{
        return extratOCRFromImage(this.computeVisionAPI.concat(V1_RECOGNIZETEXT_URI),file,language);

    }

    @PostMapping("/azure/v2/ocr")
    public Map<String,Object> extractOCRVersion2(@RequestBody @NotNull MultipartFile file, @RequestParam("language") String language) throws Exception{

        return extratOCRFromImage(this.computeVisionAPI.concat(V2_OCR_URI),file,language);
    }



    protected Map<String,Object> extratOCRFromImage(String url, MultipartFile file, String language) throws Exception{

        if(logger.isInfoEnabled()) { logger.info("analyze image with file name {} and language {}"  ,file.getOriginalFilename(),language); }
        language = StringUtils.isEmpty(language) ? "unk" : language;
        if(logger.isInfoEnabled()) { logger.info("language detected {}", language); }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        headers.add("Ocp-Apim-Subscription-Key",this.azureKey);
        InputStream inputStream = file.getInputStream();
        HttpEntity<Object> httpEntity = new HttpEntity<>(FileCopyUtils.copyToByteArray(inputStream),headers);

        ResponseEntity<String> responseEntity = this.restTemplate.exchange(url.concat("?language="+language), HttpMethod.POST
                ,httpEntity,String.class,new Object[]{});
        if(logger.isInfoEnabled()){
            logger.info("response entity {}",responseEntity.getStatusCode());
            logger.info("response data {}",responseEntity.getBody());
        }

        AzureOCRImageResponse response = mapper.readValue(responseEntity.getBody(), AzureOCRImageResponse.class);
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("lanaguage",language);
        if(response !=null){
            List<String> texts =  response.getRegions().stream()
                    .map(Region::getLines)
                    .flatMap(Collection::stream)
                    .map(Line::getWords)
                    .flatMap(Collection::stream)
                    .map(Word::getText)
                    .collect(Collectors.toList());

            responseMap.put("textFindings",texts);
        }

        return responseMap;



    }
}
