package com.thoughtworks.capability.gtb.vo;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventVo {

  private String id;
  private String name;
  private EventType type;
  @JsonSerialize(using = CustomDateSerialize.class)
  private Date time;
  @JsonUnwrapped
  private UserVo user;
}

class CustomDateSerialize extends StdSerializer<Date> {

  protected CustomDateSerialize() {
    super(Date.class);
  }

  @Override
  public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeNumber(date.getTime());
  }
}
