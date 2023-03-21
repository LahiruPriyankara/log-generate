package com.lhu.loggenerate.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
// @Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

  private static int requestId = 1;
  public static final String DEFAULT_REQUEST_TOKEN_HEADER = "Request_Token";
  public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
  public static final String REQUEST_IDENTIFYING_MDC_TOKEN_KEY = "REQ_UNQ_ID";

  @Override
  protected void doFilterInternal(
      final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
      throws java.io.IOException, ServletException {
    try {
      String token = request.getHeader(DEFAULT_REQUEST_TOKEN_HEADER);
      if (Objects.isNull(token) || token.isBlank()) {
        token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
      }
      MDC.put(REQUEST_IDENTIFYING_MDC_TOKEN_KEY, token);

      response.addHeader(DEFAULT_RESPONSE_TOKEN_HEADER, token);
      chain.doFilter(request, response);
    } finally {
      MDC.remove(REQUEST_IDENTIFYING_MDC_TOKEN_KEY);
    }
  }
}
