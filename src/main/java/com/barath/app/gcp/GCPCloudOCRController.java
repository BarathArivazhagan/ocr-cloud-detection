package com.barath.app.gcp;


import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.Feature;

@Profile("gcp")
@RestController(value="/gcp")
public class GCPCloudOCRController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final CloudOCRService cloudOCRService;


    public GCPCloudOCRController(CloudOCRService cloudOCRService) {
        this.cloudOCRService= cloudOCRService;
    }


    @PostMapping(value="/documentType/extractText")
    public  List<String> extractTextByDocumentType(@RequestBody @NotNull  MultipartFile file) throws Exception {

        logger.info("extract text by document type is invoked with file name {}",file.getOriginalFilename());
        return this.cloudOCRService.extractTextLabelsByDocumentType(file);
    }

    @PostMapping(value = "/textType/extractText")
    public  List<String> extractTextByTextType(@RequestBody @NotNull  MultipartFile file) throws Exception {

        logger.info("extract text by text type is invoked with file name {}",file.getOriginalFilename());
        return this.cloudOCRService.extractTextLabelsByTextType(file);
    }

    @PostMapping(value = "/extractLabels")
    public  List<String> extractLabels(@RequestBody @NotNull  MultipartFile file) throws Exception {

        logger.info("extract labels is invoked with file name {}",file.getOriginalFilename());
        return this.cloudOCRService.extractLabels(file);
    }

    @PostMapping(value = "/extractText/{type}")
    public  List<String> extractLabels(@RequestBody @NotNull  MultipartFile file, @PathVariable String detectionType) throws Exception {

        logger.info("extract text with type {} and file name {}",detectionType,file.getOriginalFilename());
        return this.cloudOCRService.extractTextLabels(file, Feature.Type.valueOf(detectionType));
    }



}