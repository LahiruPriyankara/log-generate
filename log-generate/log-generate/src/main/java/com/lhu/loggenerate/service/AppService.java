package com.lhu.loggenerate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppService {
  public void testOne() {
    log.info("AppService.testOne Method Called");
  }
}
