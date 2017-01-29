package gwtest;

import protocol.ProtocolHeader;
import services.RecordSet;
import services.RecordSetException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by bobsol on 28.01.17.
 */
public class ProtocolHeaderMapper {
    public synchronized static ProtocolHeader findByGUID(UUID guid){

        ProtocolHeaderRow row = ProtocolHeaderGateway.findByGUID(guid);
        ProtocolHeader ph = new ProtocolHeader.ProtocolHeaderBuilder(row).build();

    return ph;
    }

    public synchronized static void insert(ProtocolHeader ph){
        ProtocolHeaderGateway.insert(toRow(ph));
    }

    public synchronized static void updateByGuid(ProtocolHeader ph){

        ProtocolHeaderGateway.updateByGuid(toRow(ph));
    }

    private static ProtocolHeaderRow toRow(ProtocolHeader ph){
        ProtocolHeaderRow row = new ProtocolHeaderRow();
        row.set("guid", ph.getGuid().toString());
        row.set("pfDate", ph.getPfDate().toString());
        row.set("pfTime", ph.getPfTime().toString());
        row.set("pfVRT", ph.getPfVRT());
        row.set("ivfAttempt", ph.getIvfAttempt());
        row.set("pfDoctor", ph.getPfDoctor());
        row.set("pfDiagnosis", ph.getPfDiagnosis());
        row.set("pfHeaderNotes", ph.getPfHeaderNotes());
        row.set("isOms", ph.getIsOms());
        row.set("fName", ph.getFName());
        row.set("fDOB", ph.getFDOB().toString());
        row.set("fCode", ph.getFCode());
        row.set("mName", ph.getMName());
        row.set("mDOB", ph.getMDOB().toString());
        row.set("mCode", ph.getMCode());

        return row;
    }
}
