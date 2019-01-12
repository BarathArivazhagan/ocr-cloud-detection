package com.barath.app.aws;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Profile("aws")
@Service
public class AWSOCRService  {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final AmazonRekognition rekognitionClient;

    public AWSOCRService(AmazonRekognition rekognitionClient) {
        this.rekognitionClient=rekognitionClient;
    }


    public List<String> extractText(MultipartFile file) {

        logger.info(" extract text {}",file.getOriginalFilename());


        List<TextDetection> textDetections = Collections.emptyList();
        try {
            DetectTextRequest request = new DetectTextRequest()
                    .withImage( new Image().withBytes(ByteBuffer.wrap(FileCopyUtils.copyToByteArray(file.getInputStream()))));
            DetectTextResult result = rekognitionClient.detectText(request);
            textDetections = result.getTextDetections();

            logger.info("Detected lines and words for " + file.getOriginalFilename());
            for (TextDetection text: textDetections) {

                System.out.println("Detected: " + text.getDetectedText());
                System.out.println("Confidence: " + text.getConfidence().toString());
                System.out.println("Id : " + text.getId());
                System.out.println("Parent Id: " + text.getParentId());
                System.out.println("Type: " + text.getType());
                System.out.println();
            }
        } catch(AmazonRekognitionException | IOException e) {
            e.printStackTrace();
        }
        return textDetections.isEmpty() ? Collections.EMPTY_LIST : textDetections.stream().map(TextDetection::getDetectedText).collect(Collectors.toList());
    }
}
