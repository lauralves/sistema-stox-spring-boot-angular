package com.example.demo.domain.databind;

import com.example.demo.domain.Estoque;
import com.example.demo.domain.Fornecedor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class EstoqueDatabind {
    public static class IdDeserializer extends JsonDeserializer<Estoque> {
        @Override
        public Estoque deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                Estoque c = new Estoque();
                c.setId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                Estoque c = new Estoque();
                c.setId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<Estoque> {
        @Override
        public void serialize(Estoque entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getId());
        }
    }
}
