package com.example.demo.domain.databind;

import com.example.demo.domain.HistoricoProduto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class VendaDatabind {
    public static class IdDeserializer extends JsonDeserializer<HistoricoProduto> {
        @Override
        public HistoricoProduto deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                HistoricoProduto c = new HistoricoProduto();
                c.setId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                HistoricoProduto c = new HistoricoProduto();
                c.setId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<HistoricoProduto> {
        @Override
        public void serialize(HistoricoProduto entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getId());
        }
    }
}
