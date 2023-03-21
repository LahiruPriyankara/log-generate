package com.lhu.loggenerate.controller;

import com.lhu.loggenerate.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
@Slf4j
public class AppController {

  @Autowired private AppService appService;

  Logger logger = LoggerFactory.getLogger(AppController.class);

  @GetMapping("get/one")
  public ResponseEntity<String> getTestOne() {
    logger.info("getTestOne Method Called...");

    logger.info("Logger-Info");
    logger.error("Logger-error");
    logger.debug("Logger-debug");
    logger.warn("Logger-warn");
    logger.trace("Logger-trace");

    log.info("Slf4j-Info");
    log.error("Slf4j-error");
    log.debug("Slf4j-debug");
    log.warn("Slf4j-warn");
    log.trace("Slf4j-trace");

    appService.testOne();

    return ResponseEntity.ok("getTestOne Method Called...");
  }

  @GetMapping("get/two")
  public ResponseEntity<String> getTestTwo() {
    logger.info("getTestTwo Method Called...");
    int a = 1/0;
    return ResponseEntity.ok("getTestTwo Method Called...");
  }
}
