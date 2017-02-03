package controllers;

import experiment.SQLiteTasks;
import experiment.SQLiteTasksBackUP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import protocol.maps.VitrifiedEmbryo;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micro on 02.02.2017.
 */
public class VitrifiedEmbryoService {

    private static final Logger logger = Logger.getLogger(VitrifiedEmbryoService.class.getName());




    public ObservableList<VitrifiedEmbryo> getVitrifiedEmbryosList(){
        ObservableList<VitrifiedEmbryo> vitrifiedEmbryos = FXCollections.observableArrayList();

        FetchVitrifiedEmbryosTask fetchVitrified = new FetchVitrifiedEmbryosTask();

        try {
             vitrifiedEmbryos.addAll(fetchVitrified.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vitrifiedEmbryos;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        logger.info("Getting a database connection");
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:embry-test.db");
    }



    abstract class DBTask<T> extends Task<T> {
        DBTask() {
            setOnFailed(t -> logger.log(Level.SEVERE, null, getException()));
        }
    }

    class FetchVitrifiedEmbryosTask extends DBTask<ObservableList<VitrifiedEmbryo>> {


        @Override
        protected ObservableList<VitrifiedEmbryo> call() throws Exception {
            try (Connection con = getConnection()) {
                return fetchNames(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


        private ObservableList<VitrifiedEmbryo> fetchNames(Connection con) throws SQLException {
            logger.info("Fetching names from database");
            ObservableList<VitrifiedEmbryo> names = FXCollections.observableArrayList();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM VitrifiedEmbryo");


            while (rs.next()) {
                String id = rs.getString("guid");
                String strawNumber = rs.getString("strawNumber");
                String embryoNumber = rs.getString("embryoNumber");

                VitrifiedEmbryo ve;
                ve = new VitrifiedEmbryo
                        .VitrifiedEmbryoBuilder(
                                id,
                                strawNumber,
                                embryoNumber)
                        .cryoDpf(rs.getString("cryoDpf"))
                        .cryoStage(rs.getString("cryoStage"))
                        .cryoNotes(rs.getString("cryoNotes"))
                        .cryoEmbryologist(rs.getString("cryoEmbryologist"))
                        .defrostDate(rs.getString("defrostDate"))
                        .defrostEmbryoQuality(rs.getString("defrostEmbryoQuality"))
                        .defrostMedia(rs.getString("defrostMedia"))
                        .defrostEmbryologist(rs.getString("defrostEmbryologist"))
                        .defrostSurvival(rs.getString("defrostSurvival"))
                        .build();
                names.add(ve);
            }
            logger.info("Found " + names.size() + " names");
            return names;
        }
    }

