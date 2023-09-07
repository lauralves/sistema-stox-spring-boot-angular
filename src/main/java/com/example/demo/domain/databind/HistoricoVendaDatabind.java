package com.example.demo.domain.databind;

import com.example.demo.domain.Funcionario;
import com.example.demo.domain.HistoricoVenda;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class HistoricoVendaDatabind {
    public static class IdDeserializer extends JsonDeserializer<HistoricoVenda> {
        @Override
        public HistoricoVenda deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                HistoricoVenda c = new HistoricoVenda();
                c.setId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                HistoricoVenda c = new HistoricoVenda();
                c.setId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<HistoricoVenda> {
        @Override
        public void serialize(HistoricoVenda entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getId());
        }
    }
}
