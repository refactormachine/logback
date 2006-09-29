package ch.qos.logback.access.pattern;

import ch.qos.logback.access.spi.AccessEvent;
import ch.qos.logback.core.util.OptionHelper;


public class RequestParameterConverter extends AccessConverter {

  String key;

  public void start() {
    key = getFirstOption();
    if (OptionHelper.isEmpty(key)) {
      addWarn("Missing key for the request parameter");
    } else {
      super.start();
    }
  }

  protected String convert(AccessEvent accessEvent) {
    if (!isStarted()) {
      return "INACTIVE_REQUEST_PARAM_CONV";
    }

    return accessEvent.getRequestParameter(key);
  }

}
