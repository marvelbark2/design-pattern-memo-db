package adaptor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import db.BaseRecord;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loader<T> {

    public Loader(String fileName, RecordHandler<T> recordHandler, Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
            List<T> data = mapper.readValue(new File(fileName), listType);
            data.forEach(recordHandler::addRecord);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
