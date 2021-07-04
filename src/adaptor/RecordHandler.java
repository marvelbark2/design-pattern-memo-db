package adaptor;

import db.BaseRecord;

public interface RecordHandler <T> {
    void addRecord(T obj);
}
