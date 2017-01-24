package services;

import models.*;
import protocol.PgsCryoEt;
import protocol.Spermiogramm;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by micro on 24.01.2017.
 */
public class SQLmodelVisitor implements Visitor {

    @Override
    public void visit(DefaultValuesModel model) {
        Set<String> list =  model.getValuesMap().keySet();

        for (String key: list){

        }
    }

    @Override
    public void visit(ProtocolHeaderModel model) {

    }

    @Override
    public void visit(FertilizationModel model) {

    }

    @Override
    public void visit(FolliclePunctureModel model) {

    }

    @Override
    public void visit(PgsCryoEt model) {

    }

    @Override
    public void visit(CultivationTableModel model) {

    }

    @Override
    public void visit(Spermiogramm model) {

    }
}
