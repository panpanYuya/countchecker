package com.creepyy.countchecker.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("constipation")
public class ConstipationController {

  @RequestMapping("/post")
  public ResponseEntity<String> post() {
    return new ResponseEntity<String>("ok", HttpStatus.OK);
  }
}
