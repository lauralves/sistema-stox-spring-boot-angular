package com.example.app.domain.databind;

import com.example.app.domain.TipoFuncionario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class TipoFuncionarioDatabind {
    public static class IdDeserializer extends JsonDeserializer<TipoFuncionario> {
        @Override
        public TipoFuncionario deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isNumber()) {
                TipoFuncionario c = new TipoFuncionario();
                c.setId(node.asLong());
                return c;
            } else if (node.isObject()) {
                JsonNode id = node.get("id");
                TipoFuncionario c = new TipoFuncionario();
                c.setId(id.asLong());
                return c;
            }
            return null;
        }
    }

    public static class IdSerializer extends JsonSerializer<TipoFuncionario> {
        @Override
        public void serialize(TipoFuncionario entity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
                IOException {
            jsonGenerator.writeNumber(entity.getId());
        }
    }
}
