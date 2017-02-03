
            String sql2c = "CREATE TABLE legal_queries( \n" +
                    "ID STRING PRIMARY KEY NOT NULL,\n" +
                    "QUERY_NAME TEXT NOT NULL, \n"+
                    "QUERY_STRING TEXT NOT NULL \n" +
                    ");";

            String sql2 = "INSERT INTO legal_queries VALUES(\n" +
                    "'" + UUID.randomUUID().toString() + "'" +
                    ", 'control_list_names', " +
                    "'SELECT table_name FROM default_lists');";


                        String sql5 = "INSERT INTO DOCTORS " +
                                            "VALUES('" + UUID.randomUUID().toString() + "', 'Гвасалия Р.Г.')," +
                                            "('" + UUID.randomUUID().toString() + "', 'Шарфи Ю.Н.')," +
                                            "('" + UUID.randomUUID().toString() + "', 'Геркулов Д.А.')," +
                                            "('" + UUID.randomUUID().toString() + "', 'Жарова М.В.');";



            String sql = "CREATE TABLE legal_queries( \n" +
                        "ID STRING PRIMARY KEY NOT NULL,\n" +
                    "QUERY_NAME TEXT NOT NULL, \n"+
                    "QUERY_STRING TEXT NOT NULL \n" +
                    ");";
            String sql3 =  "CREATE TABLE default_lists( \n" +
                    "ID STRING PRIMARY KEY NOT NULL,\n" +
                    "TABLE_NAME TEXT NOT NULL \n"+
                    "QUERY_STRING TEXT NOT NULL);";
                                String sql2 = "INSERT INTO legal_queries VALUES(\n" +
                                          "'" + UUID.randomUUID().toString() + "'" +
                                            ", 'control_list_names', " +
                                            "'SELECT  * FROM default_lists');";

String sql4 = "INSERT INTO default_lists \n" +
        "VALUES( '" + UUID.randomUUID().toString() + "'" + ", 'DOCTORS', 'SELECT CONTROL_VALUE FROM DOCTORS;')," +
        "( '" + UUID.randomUUID().toString() + "'" + ", 'NURSES', 'SELECT CONTROL_VALUE FROM NURSES;')," +
        "( '" + UUID.randomUUID().toString() + "'" + ", 'EMBRYOLOGISTS', 'SELECT CONTROL_VALUE FROM EMBRYOLOGISTS;')," +

        "( '" + UUID.randomUUID().toString() + "'" + ", 'DIAGNOSES', 'SELECT CONTROL_VALUE FROM DIAGNOSES;')," +

        "( '" + UUID.randomUUID().toString() + "'" + ", 'CATHETERS', 'SELECT CONTROL_VALUE FROM CATHETERS;')," +

        "( '" + UUID.randomUUID().toString() + "'" + ", 'SPERM_PREPARATION_REASONS', 'SELECT CONTROL_VALUE FROM SPERM_PREPARATION_REASONS;');";

            String sql5c = "CREATE TABLE DOCTORS(\n" +
                        "ID TEXT PRIMARY KEY NOT NULL, \n" +
                    "FULL_NAME TEXT NOT NULL, \n"+
                    "CONTROL_VALUE TEXT NOT NULL \n" +
                    ");";
              String sql5 = "INSERT INTO DOCTORS " +
                    "VALUES('" + UUID.randomUUID().toString() + "', 'Гвасалия Русудан Гивиевна','Гвасалия Р.Г.')," +
                    "('" + UUID.randomUUID().toString() + "', 'Шарфи Юлия Нажибовна','Шарфи Ю.Н.')," +
                    "('" + UUID.randomUUID().toString() + "', 'Геркулов Дмитрий Андреевич','Геркулов Д.А.')," +
                    "('" + UUID.randomUUID().toString() + "', 'Жарова Мария Валерьевна','Жарова М.В.');";

            String sql6 = "INSERT INTO NURSES " +
                    "VALUES('" +UUID.randomUUID().toString() + "','','Ефимова Я.Е')," +
                    "('" +UUID.randomUUID().toString() + "','',"+"'Хлебосолова С.Д.')," +
                    "('" +UUID.randomUUID().toString() + "','',"+"'Гайворонская А.А.')," +
                    "('" +UUID.randomUUID().toString() + "','',"+"'Аверина Я.В.')," +
                    "('" +UUID.randomUUID().toString() + "','',"+"'Твердохлеб О.М.')," +
                    "('" +UUID.randomUUID().toString() + "','',"+"'Шефер О.А.');";

                    String sql6c = "CREATE TABLE NURSES(\n" +
                    "ID TEXT PRIMARY KEY NOT NULL, \n" +
                    "FULL_NAME TEXT NOT NULL, \n"+
                    "CONTROL_VALUE TEXT NOT NULL \n" +
                    ");";



            String sql7c = "CREATE TABLE EMBRYOLOGISTS(\n" +
                    "ID TEXT PRIMARY KEY NOT NULL, \n" +
                    "FULL_NAME TEXT NOT NULL, \n"+
                    "CONTROL_VALUE TEXT NOT NULL \n" +
                    ");";


            String sql7i= "INSERT INTO EMBRYOLOGISTS " +
                    "VALUES('" +UUID.randomUUID().toString() + "','Лямина Ирина Владимировна','Лямина И.В.')," +
                    "('" +UUID.randomUUID().toString() + "','Мурза Галина Валерьевна',"+"'Мурза Г.В.')," +
                    "('" +UUID.randomUUID().toString() + "','Хандога Антонина Олеговна',"+"'Хандога А.О.')," +
                    "('" +UUID.randomUUID().toString() + "','Соловьев Роберт Сергеевич',"+"'Соловьев Р.С.')," +
                    "('" +UUID.randomUUID().toString() + "','Черноштан Ксения Владимировна',"+"'Черноштан К.В.');";

            String sql8c ="CREATE TABLE DIAGNOSES(ID STRING NOT NULL PRIMARY KEY, CONTROL_VALUE TEXT NOT NULL, " +
                    "MEANING TEXT NOT NULL);";

            String sql8i = "INSERT INTO DIAGNOSES VALUES\n" +
                    "('" + UUID.randomUUID().toString() + "', '97.0', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.1', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.2', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.3', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.4', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.8', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.0 + 97.4', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.1 + 97.4', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.2 + 97.4', '')," +
                    "('" + UUID.randomUUID().toString() + "', '97.3 + 97.4', '');";
            String sql9c = "CREATE TABLE CATHETERS( ID TEXT PRIMARY KEY  NOT NULL, FULL_NAME TEXT NOT NULL, CONTROL_VALUE TEXT NOT NULL);";
            String sql9i = "INSERT INTO CATHETERS VALUES\n" +

                    "('" + UUID.randomUUID().toString() + "', '', 'CCD Pearl Tip')," +
                    "('" + UUID.randomUUID().toString() + "', '', 'COOK 7019')," +
                    "('" + UUID.randomUUID().toString() + "', '', 'CCD T.D.T.')," +
                    "('" + UUID.randomUUID().toString() + "', '', 'Rocket');";


            String r1 = "В связи с малым количеством ооцитов (2 ооцита), полученных в результате трансвагинальной пункции фолликулов, было принято решение о проведении процедуры ИКСИ (инъекции сперматозоида в цитоплазму ооцита).";
            String r2 = "В связи с тем, что показатели эякулята, полученного в день проведения  трансвагинальной пункции фолликулов,  были ниже нормативных значений, было принято решение о проведении процедуры ИКСИ (инъекции сперматозоида в цитоплазму ооцита).";
            String r3 ="По результатам анализа обработанного эякулята было выявлено снижение качества показателей, что делает невозможным использования данного образца для проведения ЭКО (экстракорпоральное оплодотворение). Проведена процедура ИКСИ (инъекции сперматозоида в цитоплазму ооцита).";

            String sql10c = "CREATE TABLE SPERM_PREPARATION_REASONS(ID TEXT PRIMARY KEY NOT NULL, CONTROL_VALUE STRING NOT NULL);";
            String sql10i = "INSERT INTO SPERM_PREPARATION_REASONS VALUES\n" +
                    "('" + UUID.randomUUID().toString() + "', '" + r1 + "')," +
                    "('" + UUID.randomUUID().toString() + "', '" + r2 + "')," +
                    "('" + UUID.randomUUID().toString() + "', '" + r3 + "');";

            CREATE TABLE PROTOCOL_HEADER(
                GUID STRING PRIMARY KEY NOT NULL,
                pfDate STRING NOT NULL,
                pfTime  STRING NOT NULL,
                pfVRT  STRING NOT NULL,
                ivfAttempt STRING NOT NULL,
                pfDoctor  STRING NOT NULL,
                isOms STRING NOT NULL,
                pfDiagnosis STRING NOT NULL,
                pfHeaderNotes STRING NOT NULL,
                fName STRING NOT NULL,
                fCode STRING NOT NULL,
                fDOB  STRING NOT NULL,
                mName STRING,
                mCode STRING,
                mDOB STRING
                );
String sql = "INSERT INTO legal_queries VALUES(" +
"'" + UUID.randomUUID().toString() + "'," +
"'PROTOCOL_HEADER_FIND_BY_GUID'," +
"'SELECT * FROM PROTOCOL_HEADER WHERE ID');"

String sql =   "INSERT INTO PROTOCOL_HEADER VALUES(" +
                "'" + UUID.randomUUID().toString() + "'," +
                "'01.10.2010'," +
                "'10:30'," +
                "'C010/101010/2010',"+
                "'10',"+
                "'Гвасалия Р.Г.',"+
                "'1',"+
                "'97.1',"+
                "'HepC female',"+
                "'Десятникова Анна Петровна',"+
                "'101010',"+
                "'10.01.1987',"+
                "'Десятников Петр Григорьевич',"+
                "'919191',"+
                "'19.01.1987'"+
                ");";
String sql = "INSERT INTO legal_queries VALUES('" + UUID.randomUUID().toString() +"',\n" +
        "'PROTOCOL_HEADER_FIND_ALL', 'SELECT * FROM PROTOCOL_HEADER;');";
insertSQL(sql);
'guid,procedure_type,embryologist,time_1,witness_1,time_2,witness_2'
String sql=
"INSERT INTO pojo_keysets VALUES('" + UUID.randomUUID() + "', 'FOLLICLE_PUNCTURE','guid,embryologist,nurse,harvested_count');";
INSERT INTO pojo_keysets VALUES
('69ee30f6-5d3e-4f7c-9f12-f0cad1a545e2', 'FOLLICLE_PUNCTURE', 'guid,embryologist,nurse,harvested_count');
INSERT INTO pojo_keysets VALUES
('e9210843-1361-4327-abf6-c792e673ef7e', 'FERTILIZATION', 'guid,procedure_type,embryologist,time_1,witness_1,time_2,witness_2');
INSERT INTO pojo_keysets VALUES
('9dba3f2d-c763-42de-83d7-92798b45d343', 'PROTOCOL_HEADER', 'guid,pfDate,pfTime,pfVRT,ivfAttempt,pfDoctor,isOms,pfHeaderNotes,pfDiagnosis,fName,fDOB,fCode,mName,mDOB,mCode');
INSERT INTO pojo_keysets VALUES
('356cd1a0-ff31-4c5e-a1c7-2771b6cad1f5', 'FEMALE_SOURCE', 'guid,source,material_type,cryo_date,expected_follicle_count');
INSERT INTO pojo_keysets VALUES
('4743a382-73ec-4c9f-8fcd-81591e97fab3', 'CHECK_POINTS', 'guid,fertilization_check_by,media_changed_by,vitrified_by,utilized_by');
INSERT INTO pojo_keysets VALUES
('af6d3023-3024-4c35-88bc-4685d22e6b6d', 'CONDITIONS', 'guid,cleavage_lot,blastocyst_lot,sps_lot,hepes_lot,ovoil_lot,incubator,special_case_note');
INSERT INTO pojo_keysets VALUES
('519b5cd5-f6f3-414e-a756-7beb1a6ae138', 'ET_CRYO_PGS', 'guid,et_day,et_note,Vitrification_decision,max_embryos_cryo,max_straws_cryo,pgs_type,pgs_note');
INSERT INTO pojo_keysets VALUES
('55c2ae88-ab5f-4b00-b398-b26927439664', 'CONCLUSION', 'guid,okk,m2,m1,gv,abn,atr,used_for_fertilization,fertilized,transfered,vitrified,pregnancy');
INSERT INTO pojo_keysets VALUES
('6c190504-8a33-46d4-9fe1-d9fc4d37d904', 'VITRIFICATION', 'guid,vitDate,fName,fDOB,vitVRT,fCode,mName,mDOB,media_date,dewar,canister,color,embryo_count,straw_count,sections_count');
INSERT INTO pojo_keysets VALUES
('d952cb20-b353-4c52-b9ba-f7470c0823d4', 'MALE_SOURCE', 'guid,source,material_type,cryo_date,biopsy_type');
INSERT INTO pojo_keysets VALUES
('620b1289-c8cc-4b6f-94c5-d31c9a199f6a', 'SPERMIOGRAMM', 'guid,time_1,time_2,time_3,concentration,volume,viscosity,morphology,ab_native,c_native,d_native,method,ab_postprep,c_postprep,d_postprep,concentration_postprep,add_to_700,add_to_1000,embryologist,sperm_note');
INSERT INTO pojo_keysets VALUES
('486cab69-e832-4639-a1f6-11099471e9ef', 'EMBRYO_TRANSFER', 'guid,etDay,etTime,etDpf,etCount,etDoctor,etNurse,etEmbryologist,catheter,catheter_hard,catheter_replacement,mucus,blood,etRepeat,visible,no_ultra_sound,surogate_mother');



UPDATE pojo_keysets SET keyset='guid,time_1,time_2,time_3,concentration,volume,viscosity,morphology,ab_native,c_native,d_native,method,ab_postprep,c_postprep,d_postprep,concentration_postprep,add_to_700,add_to_1000,embryologist,sperm_note'
 WHERE guid='620b1289-c8cc-4b6f-94c5-d31c9a199f6a'; 'guid,time_1,time_2,time_3,concentration,volume,viscosity,morphology,ab_native,c_native,d_native,method,ab_postprep,c_postprep,d_postprep,concentration_postprep,add_to_700,add_to_1000,embryologist,sperm_note');
String sql="INSERT INTO FERTILIZATION VALUES('61c7628a-2551-4ce5-b134-efd00289d72a', 'ИКСИ', 'Хандога А.О.', '14:10', 'Мурза Г.В.', '', '');";
 procedure_type STRING,
 embryologist STRING,
 time_1 STRING,
 witness_1 STRING,
 time_2 STRING,
 witness_2 STRING
 );

CREATE TABLE VitrifiedEmbryo (
    guid        STRING NOT NULL,
    strawNumber STRING NOT NULL,
    embryoNumber STRING NOT NULL,
    cryoDpf     STRING,
    cryoStage   STRING,
    cryoNotes   STRING,
    cryoEmbryologist  STRING,
    defrostDate  STRING,
    defrostEmbryoQuality STRING,
    defrostMedia STRING,
    defrostEmbryologist STRING,
    defrostSurvival STRING,
PRIMARY KEY(GUID, strawNumber, embryoNumber)
);
CREATE TABLE VitrifiedEmbryo (
    guid        STRING NOT NULL,
    strawNumber STRING NOT NULL,
    embryoNumber STRING NOT NULL,
    cryoDpf     STRING,
    cryoStage   STRING,
    cryoNotes   STRING,
    cryoEmbryologist  STRING,
    defrostDate  STRING,
    defrostEmbryoQuality STRING,
    defrostEmbryologist STRING,
    defrostSurvival STRING,
PRIMARY KEY(GUID, strawNumber, embryoNumber)
);

INSERT INTO VitrifiedEmbryo VALUES
('61c7628a-2551-4ce5-b134-efd00289d72a', '1', '1', '5', 'BL5AB', '', 'Хандога А.О.', '', '', '', '');,

)
   String sql =       "CREATE TABLE VITRIFICATION_TABLE(
          "guid STRING NOT NULL," +
         "strawCol STRING NOT NULL" +
         "embCol STRING NOT NULL"+
           "dpfCol STRING NOT NULL"+
           "devStage STRING NOT NULL" +
           "vitNotes  STRING NOT NULL" +
         "vitSignature STRING NOT NULL" +
         "defrostDate STRING"+
         "defrostEmb STRING"+
         "defrostSignature STRING" +
         "defrostSurvival STRING );"
         PRIMARY KEY(guid, strawCol, embCol"
         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>(""));

         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("));

         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("));

         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("));
         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>(""));
         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>(" "));
         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>(""));
         strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>(""));
 CREATE TABLE FOLLICLE_PUNCTURE(
 guid STRING PRIMARY KEY NOT NULL,
 embryologist STRING,
 nurse STRING,
 harvested_count STRING
 );'
procedure_type STRING,
embryologist STRING,
time_1 STRING,
witness_1 STRING,
time_2 STRING,
witness_2 STRING
);
CREATE TABLE FOLLICLE_PUNCTURE(
guid STRING PRIMARY KEY NOT NULL,
embryologist STRING,
nurse STRING,
harvested_count STRING
);


CREATE TABLE VITRIFIED_EMBRYO()
CREATE TABLE FOLLICLE_PUNCTURE(
guid STRING PRIMARY KEY NOT NULL,
embryologist STRING,
nurse STRING,
harvested_count STRING
);


CREATE TABLE FERTILIZATION(
guid STRING PRIMARY KEY NOT NULL,
procedure_type STRING,
embryologist STRING,
time_1 STRING,
witness_1 STRING,
time_2 STRING,
witness_2 STRING
);

CREATE TABLE FEMALE_SOURCE(
guid STRING,
source STRING,
material_type STRING,
cryo_date STRING,
expected_follicle_count STRING
);


CREATE TABLE  CHECK_POINTS(
guid STRING PRIMARY KEY NOT NULL,
fertilization_check_by STRING,
media_changed_by STRING,
vitrified_by,utilized_by STRING
);

CREATE TABLE CONDITIONS(
guid STRING PRIMARY KEY NOT NULL,
cleavage_lot STRING,
blastocyst_lot STRING,
sps_lot STRING,
hepes_lot STRING,
ovoil_lot STRING,
incubator STRING,
special_case_note STRING
);


CREATE TABLE ET_CRYO_PGS(
guid  STRING PRIMARY KEY NOT NULL,
et_day STRING,
et_note STRING
Vitrification_decision STRING,
max_embryos_cryo STRING,
max_straws_cryo STRING,
pgs_type STRING,
pgs_note STRING
);

CREATE TABLE  CONCLUSION(
guid  STRING PRIMARY KEY NOT NULL,
okk STRING,
m2 STRING,
m1 STRING,
gv STRING,
abn STRING,
atr STRING,
used_for_fertilization STRING,
fertilized STRING,
transfered STRING,
vitrified,pregnancy  STRING
);
String sql = "INSERT INTO VITRFICATION VALUES\n"+
                                "('61c7628a-2551-4ce5-b134-efd00289d72a'," +
                                "'10.10.11'," +
                                "'C0101/111010/2010'," +
                                "'Иванова Афродита Сергеевна'," +
                                "'01.10.1987'," +
                                "'111010'," +
                                "'Белосельский Ибрагим Денисович'"  +
                                "'654321'"+
                                "'In house(28.09.11),'" +
                                "'10',"+
                                "'3'"+
                                "'синий'" +
                                "'4'," +
                                "'3'," +
                                "'1'," +
                                "'1'," +
                                "'0'," +
                                "'0');";

CREATE TABLE VITRIFICATION(
      guid STRING PRIMARY KEY NOT NULL,
      vitDate STRING,
      vitVRT STRING,

      fName STRING,
      fDOB STRING,
      fCode STRING,
      mName STRING,
      mDOB STRING,
      mCode String,

      vitMedia STRING,
      dewar STRING,
      canister STRING,
      sectionColor STRING,

      embryoCount STRING,
      strawCount STRING,
      sectionCount STRING,

      isOms String,
      isPostponed STRING,
      fromAnotherClinic STRING
  );


String sql = "INSERT INTO pojo_keysets VALUES\n"+
"('" + UUID.randomUUID().toString() + "', 'VITRIFICATION', 'guid,vitDate,vitVRT,fName,fDOB,fCode,mName,mDOB,mCode,vitMedia,dewar,canister,sectionColor,embryoCount,strawCount,sectionCount,isOms,isPostponedET,fromAnotherClinic');";


CREATE TABLE MALE_SOURCE(
 guid STRING,
 source STRING,
 material_type STRING,
 cryo_date,biopsy_type STRING
 );

CREATE TABLE EMBRYO_TRANSFER(
guid STRING PRIMARY KEY NOT NULL,
etDay STRING,
etTime STRING,
etDpf STRING,
etCount STRING,
etDoctor STRING,
etNurse STRING,
etEmbryologist STRING,
catheter STRING,
catheter_hard STRING,
catheter_replacement STRING,
mucus STRING,
blood STRING,
etRepeat STRING,
visible STRING,
no_ultra_sound STRING,
surogate_mother STRING
);

CREATE TABLE SPERMIOGRAMM(
guid STRING PRIMARY KEY NOT NULL,
time_1 STRING,
time_2 STRING,
time_3 STRING,
concentration STRING,
volume STRING,
viscosity STRING,
morphology STRING,
ab_native STRING,
c_native STRING,
d_native STRING,
method STRING,
ab_postprep STRING,
c_postprep STRING,
d_postprep STRING,
concentration_postprep STRING,
add_to_700 STRING,
add_to_1000 STRING,
embryologist STRING,
sperm_note STRING
);


String sqk=
"INSERT INTO pojo_keysets VALUES('\n"
 + UUID.randomUUID() + "', 'FERTILIZATION', 'guid,procedure_type,embryologist,time_1,witness_1,time_2,witness_2');";