package com.example.kafkaexample.gateways.inputs.http.external;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.kafkaexample.gateways.inputs.http.external.resources.request.KafkaMessageRequest;
import com.example.kafkaexample.usecases.PublishMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaExampleController {

  private final PublishMessage publishMessage;

  @ApiOperation(value = "Publish message")
  @ApiResponses(
      value = {
          @ApiResponse(code = 201, message = "Request has been processed."),
          @ApiResponse(code = 400, message = "Bad request. Check request and try again."),
          @ApiResponse(code = 409, message = "Conflict. Resource already exists.")
      })
  @PostMapping(
      consumes = APPLICATION_JSON_VALUE,
      produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void publishMessage( @RequestBody KafkaMessageRequest message) {
    publishMessage.execute(message.toDomain());
  }
}