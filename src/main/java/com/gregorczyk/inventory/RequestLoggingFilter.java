package com.gregorczyk.inventory;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class RequestLoggingFilter extends CommonsRequestLoggingFilter {

  public RequestLoggingFilter() {
    setIncludeQueryString(true);
    setIncludePayload(true);
    setMaxPayloadLength(10000);
    setIncludeHeaders(false);
    setBeforeMessagePrefix("Request: [");
    setAfterMessagePrefix("Response: ");
  }

  @Override
  protected boolean shouldLog(HttpServletRequest request) {
    return true;
  }

  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    logger.info(message);
  }

  @Override
  protected void afterRequest(HttpServletRequest request, String message) {
    logger.info(message);
  }
}
