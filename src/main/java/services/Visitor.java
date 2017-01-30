package services;

import models.*;
import protocol.old.pojos.PgsCryoEt;
import protocol.old.pojos.Spermiogramm;

/**
 * Created by micro on 24.01.2017.
 */
public interface Visitor {
    void visit(DefaultValuesModel model);
    void visit(ProtocolHeaderModel model);
    void visit(FertilizationModel model);
    void visit(FolliclePunctureModel model);
    void visit(PgsCryoEt model);
    void visit(CultivationTableModel model);
    void visit(Spermiogramm model);

}
