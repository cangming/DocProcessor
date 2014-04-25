package com.example.docprocessor;

import java.util.Random;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DocProcessorDB extends SQLiteOpenHelper {
	final private static int DATABASE_VERSION = 1;
	final private static String DATABASE_NAME = "DocProcessorDB";
	public DocProcessorDB(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public DocProcessorDB(Context context, String name, CursorFactory factory, int version){
		super(context, name, factory, version);
	}

	//�F�Ҹ�ư}�C
	private String [][] PARTY_DATA = {
			{"0","�L���y","no_party"},
			{"1","��������","kmt"},
			{"2","���D�i�B��","ddp"},
			{"3","�x�W�ε��p��","tsu"},
			{"4","�˥���","pfp"},
			{"5","�L�ҹε��p��","npsu"}
	};

	//�ߩe���O��ư}�C
	private String[][] LEGISLATOR_TYPE = {
			{"0","���ꤣ����","����","all_no"},
			{"1","�@�����","����","normal_dist"},
			{"2","���a����","����","plain_native"},
			{"3","�s�ϭ���","�s��","mount_native"},
			{"4","���~��~���","���~","foreign"}
	};

	//�ߩe��ϸ�ư}�C
	private String[][] LEGIST_DIST_DATA = {
			{"1","�O�_����01���","�O�_01"},
			{"2","�O�_����02���","�O�_02"},
			{"3","�O�_����03���","�O�_03"},
			{"4","�O�_����04���","�O�_04"},
			{"5","�O�_����05���","�O�_05"},
			{"6","�O�_����06���","�O�_06"},
			{"7","�O�_����07���","�O�_07"},
			{"8","�O�_����08���","�O�_08"},
			{"100","�򶩥����","�򶩥�"},
			{"201","�s�_����01���","�s�_01"},
			{"202","�s�_����02���","�s�_02"},
			{"203","�s�_����03���","�s�_03"},
			{"204","�s�_����04���","�s�_04"},
			{"205","�s�_����05���","�s�_05"},
			{"206","�s�_����06���","�s�_06"},
			{"207","�s�_����07���","�s�_07"},
			{"208","�s�_����08���","�s�_08"},
			{"209","�s�_����09���","�s�_09"},
			{"210","�s�_����10���","�s�_10"},
			{"211","�s�_����11���","�s�_11"},
			{"212","�s�_����12���","�s�_12"},
			{"300","�y�������","�y����"},
			{"401","��鿤��01���","���01"},
			{"402","��鿤��02���","���02"},
			{"403","��鿤��03���","���03"},
			{"404","��鿤��04���","���04"},
			{"405","��鿤��05���","���05"},
			{"406","��鿤��06���","���06"},
			{"500","�s�˥����","�s�˥�"},
			{"600","�s�˿����","�s�˿�"},
			{"701","�]�߿���01���","�]��01"},
			{"702","�]�߿���02���","�]��02"},
			{"801","�O������01���","�O��01"},
			{"802","�O������02���","�O��02"},
			{"803","�O������03���","�O��03"},
			{"804","�O������04���","�O��04"},
			{"805","�O������05���","�O��05"},
			{"806","�O������06���","�O��06"},
			{"807","�O������07���","�O��07"},
			{"808","�O������08���","�O��08"},
			{"901","���ƿ���01���","����01"},
			{"902","���ƿ���02���","����02"},
			{"903","���ƿ���03���","����03"},
			{"904","���ƿ���04���","����04"},
			{"1001","�n�뿤��01���","�n��01"},
			{"1002","�n�뿤��02���","�n��02"},
			{"1101","���L����01���","���L01"},
			{"1102","���L����02���","���L02"},
			{"1200","�Ÿq�����","�Ÿq��"},
			{"1301","�Ÿq����01���","�ſ�01"},
			{"1302","�Ÿq����02���","�ſ�02"},
			{"1401","�O�n����01���","�O�n01"},
			{"1402","�O�n����02���","�O�n02"},
			{"1403","�O�n����03���","�O�n03"},
			{"1404","�O�n����04���","�O�n04"},
			{"1405","�O�n����05���","�O�n05"},
			{"1501","��������01���","����01"},
			{"1502","��������02���","����02"},
			{"1503","��������03���","����03"},
			{"1504","��������04���","����04"},
			{"1505","��������05���","����05"},
			{"1506","��������06���","����06"},
			{"1507","��������07���","����07"},
			{"1508","��������08���","����08"},
			{"1509","��������09���","����09"},
			{"1601","�̪F����01���","�̪F01"},
			{"1602","�̪F����02���","�̪F02"},
			{"1603","�̪F����03���","�̪F03"},
			{"1700","�O�F�����","�O�F��"},
			{"1800","�Ὤ�����","�Ὤ��"},
			{"1900","��򿤿��","���"},
			{"2000","���������","������"},
			{"2100","�s�������","�s����"},
			{"2200","���a����","���a��"},
			{"2300","�s�a����","�s�a��"},
			{"2400","���~��~���","���~�~"},
			{"9999","���ꤣ����","������"}
	};

	//�ߩe�򥻸�ư}�C
	private String[][] LEGISLATOR_DATA ={
			{"1","�B�u��","1","1","1"},
			{"2","�դ�N","3","2300","1"},
			{"3","�׬��k","0","9999","2"},
			{"4","���ʤ�","1","1800","1"},
			{"5","���|��","0","9999","1"},
			{"6","������","0","9999","1"},
			{"7","���f��","1","901","1"},
			{"8","���i�h","1","1602","1"},
			{"9","�Ь�Ի","0","9999","2"},
			{"10","���Ҧ�","1","808","1"},
			{"11","���f�s","1","207","1"},
			{"12","��Y��","1","807","2"},
			{"13","�d�|��","0","9999","1"},
			{"14","�d�|�@","1","201","1"},
			{"15","�d�y��","0","9999","2"},
			{"16","�d����","0","9999","2"},
			{"17","�f�ɬ�","1","405","1"},
			{"18","�f�Ǽ�","1","500","1"},
			{"19","�����A","1","1506","2"},
			{"20","���T��","1","1200","2"},
			{"21","���仨","0","9999","4"},
			{"22","���Q��","0","9999","1"},
			{"23","���y��","1","212","1"},
			{"24","������","0","9999","2"},
			{"25","���E�v","1","204","1"},
			{"26","�L���s","1","806","2"},
			{"27","�L����","1","1504","2"},
			{"28","�L���L","1","1002","1"},
			{"29","�L����","1","5","1"},
			{"30","�L�꥿","1","1509","1"},
			{"31","�L�Q��","1","202","2"},
			{"32","�L�ɱ�","1","902","1"},
			{"33","�L�w��","1","209","1"},
			{"34","�L�E��","1","206","1"},
			{"35","�����","0","9999","1"},
			{"36","���Ӱ�","1","1502","2"},
			{"37","��ĳ��","1","1501","2"},
			{"38","���崼","1","2","2"},
			{"39","�_�ػ�","0","9999","2"},
			{"40","�q�y�d","0","9999","2"},
			{"41","�x�q�W","0","9999","1"},
			{"42","�����","0","9999","1"},
			{"43","�]�j�d","1","406","1"},
			{"44","�}�ֵ�","0","9999","1"},
			{"45","�}�Y��","1","600","1"},
			{"46","�}ģ��","1","702","1"},
			{"47","�έ��v","1","1301","1"},
			{"48","����g","1","1001","1"},
			{"49","�����P","1","203","2"},
			{"50","��������","3","2300","5"},
			{"51","�i�Űp","1","1101","1"},
			{"52","�i�y��","1","208","1"},
			{"53","�P�٦w","0","9999","3"},
			{"54","�\�K�]","1","1404","2"},
			{"55","�\����","1","1508","2"},
			{"56","������","0","9999","2"},
			{"57","���ɼ�","0","9999","4"},
			{"58","������","1","1302","2"},
			{"59","���F�m","1","1403","2"},
			{"60","����s","1","1405","2"},
			{"61","���ڼw","1","401","1"},
			{"62","���Q�z","0","9999","1"},
			{"63","������","1","2100","0"},
			{"64","���W��","1","701","1"},
			{"65","���`�p","0","9999","2"},
			{"66","���Ѳ[","0","9999","1"},
			{"67","���ڬ�","1","300","2"},
			{"68","���Ǹt","1","403","1"},
			{"69","�����","0","9999","1"},
			{"70","������","0","9999","1"},
			{"71","�O�E��","1","7","1"},
			{"72","�ஶ��","0","9999","3"},
			{"73","���Ӷ�","1","205","1"},
			{"74","���L��","1","1503","1"},
			{"75","������","1","1402","2"},
			{"76","���ɪY","0","9999","1"},
			{"77","������","1","2000","1"},
			{"78","���`","1","1900","2"},
			{"79","��ã��","1","803","1"},
			{"80","���R��","1","404","1"},
			{"81","���y�z","1","1401","2"},
			{"82","���z�a","0","9999","3"},
			{"83","��ͦ�","4","2400","1"},
			{"84","������","1","402","1"},
			{"85","�����","2","2200","1"},
			{"86","�޺Ѭ�","1","1505","2"},
			{"87","������","1","1507","2"},
			{"88","�B�ذ�","1","1102","2"},
			{"89","�B�g��","1","1700","2"},
			{"90","��s�w","1","1603","2"},
			{"91","�����","0","9999","1"},
			{"92","������","1","4","1"},
			{"93","�����","1","801","2"},
			{"94","���׷�","0","9999","2"},
			{"95","���A��","1","804","1"},
			{"96","���D��","1","6","1"},
			{"97","�G�Ѱ]","2","2200","1"},
			{"98","�G����","1","903","1"},
			{"99","�G�R�g","0","9999","2"},
			{"100","�c�q�P","1","805","1"},
			{"101","�c�Ũ�","1","210","1"},
			{"102","�����^","0","9999","2"},
			{"103","��h��","1","8","1"},
			{"104","����","0","9999","2"},
			{"105","�°��","1","100","1"},
			{"106","²�F��","3","2300","1"},
			{"107","�C�e��","1","802","1"},
			{"108","�Q����","1","904","2"},
			{"109","ù���~","1","211","1"},
			{"110","ù�Q��","1","3","1"},
			{"111","Ĭ�M�u","0","9999","1"},
			{"112","Ĭ�_�M","1","1601","2"}
	};

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS DATABASE_NAME");
		SQLiteStatement stmt;
		try{
			
			//CREATE TABLE PARTY_DATA�]�F�ҡ^
			String sqlPARTY_DATA = 
					"CREATE TABLE PARTY_DATA (" +
					"party_id INTEGER primary key autoincrement," +
					"party_name var not null," +
					"party_icon_path var not null);";
			db.execSQL(sqlPARTY_DATA);
	
			//INSERT DATA OF PARTY_DATA
			stmt = db.compileStatement("insert into PARTY_DATA values (?,?,?);");
			for(String[] party_content:PARTY_DATA){
				stmt.bindString(1,party_content[0]);
				stmt.bindString(2,party_content[1]);
				stmt.bindString(3,party_content[2]);
				stmt.executeInsert();
			}

			//CREATE TABLE LEGISLATOR_TYPE�]�ߩe�����^
			String sqlLEGISLATOR_TYPE = "CREATE TABLE LEGISLATOR_TYPE (" +
					"legislator_type_id INTEGER primary key autoincrement," +
					"legislator_type_name var not null," +
					"legislator_type_name_abbr var not null," +
					"legislator_type_icon_path var not null" +
					");";
			db.execSQL(sqlLEGISLATOR_TYPE);

			//INSERT DATA OF LEGISLATOR_TYPE
			stmt = db.compileStatement("insert into LEGISLATOR_TYPE values (?,?,?,?);");
			for(String[] legislator_type_content:LEGISLATOR_TYPE){
				stmt.bindString(1,legislator_type_content[0]);
				stmt.bindString(2,legislator_type_content[1]);
				stmt.bindString(3,legislator_type_content[2]);
				stmt.bindString(4,legislator_type_content[3]);
				stmt.executeInsert();
			}
			
			//CREATE TABLE LEGISLATOR_DIST_LIST�]��ϲM��^
			String sqlLEGIST_DIST_LIST = "CREATE TABLE LEGISLATOR_DIST_LIST(" +
					"legislator_dist_id INTEGER primary key autoincrement," +
					"legislator_dist_name var not null,"+
					"legislator_dist_name_abbr var not null);";
			db.execSQL(sqlLEGIST_DIST_LIST);

			//INSERT DATA OF LEGISLATOR_DIST_LIST
			stmt = db.compileStatement("insert into LEGISLATOR_DIST_LIST values (?,?,?);");
			for(String[] legist_dist_content:LEGIST_DIST_DATA){
				stmt.bindString(1,legist_dist_content[0]);
				stmt.bindString(2,legist_dist_content[1]);
				stmt.bindString(3,legist_dist_content[2]);
				stmt.executeInsert();
			}

			//CREATE TABLE LEGISLATOR DATA�]�ߩe��ơ^
			String sqlLEGISLATOR_DATA = "CREATE TABLE LEGISLATOR_DATA (" +
					"legislator_id INTEGER primary key autoincrement," +
					"legislator_name var not null," +
					"legislator_type_id INTEGER not null DEFAULT 0," +
					"legislator_dist_id INTEGER not null DEFAULT 0," +
					"legislator_party_id INTEGER not null DEFAULT 0," +
					"legislator_effective INTEGER not null DEFAULT 1," +
					"FOREIGN KEY(legislator_type_id) REFERENCES LEGISLATOR_TYPE(legislator_type_id) ON UPDATE CASCADE ON DELETE SET DEFAULT," +
					"FOREIGN KEY(legislator_party_id) REFERENCES PARTY_DATA(party_id) ON UPDATE CASCADE ON DELETE SET DEFAULT," +
					"FOREIGN KEY(legislator_dist_id) REFERENCES LEGISLATOR_DIST_LIST(legislator_dist_id) ON UPDATE CASCADE ON DELETE SET DEFAULT);";
			db.execSQL(sqlLEGISLATOR_DATA);
			
			//INSERT DATA OF LEGISLATOR_DATA
			stmt = db.compileStatement("insert into LEGISLATOR_DATA values (?,?,?,?,?,?);");
			for(String[] legislator_data_content:LEGISLATOR_DATA){
				stmt.bindString(1,legislator_data_content[0]);
				stmt.bindString(2,legislator_data_content[1]);
				stmt.bindString(3,legislator_data_content[2]);
				stmt.bindString(4,legislator_data_content[3]);
				stmt.bindString(5,legislator_data_content[4]);
				stmt.bindString(6,"1");
				stmt.executeInsert();
			}
			
			//CREATE TABLE PERSONAL_SETTING�]�ϥΪ̸�Ƴ]�w�^
			String sqlPERSONAL_SETTING = "CREATE TABLE PERSONAL_SETTING (" +
					"userid INTEGER primary key autoincrement," +
					"legislator_dist_id INTEGER," +
					"current_district_legislator_id INTEGER," +
					"current_district_legislator_name var," +
					"nickname var," +
					"password var," +
					"staff_id var," +
					"docprocessor_url var," +
					"app_instance_id INTEGER," +
					"app_instance_id_key var," +
					"FOREIGN KEY(current_district_legislator_id) REFERENCES LEGISLATOR_DATA(legislator_id) ON UPDATE CASCADE ON DELETE SET NULL," +
					"FOREIGN KEY(legislator_dist_id) REFERENCES LEGISLATOR_DIST_LIST(legislator_dist_id) ON UPDATE CASCADE ON DELETE SET NULL" +
					");";
			db.execSQL(sqlPERSONAL_SETTING);
			
			//��J�Ĥ@�����
			String[] keyStoneString = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
			String keyString = "";
			Random r = new Random();
			for(int i=0;i<16;i++)
			{
				keyString = keyString+keyStoneString[r.nextInt(15)];
			}
			sqlPERSONAL_SETTING = "INSERT INTO PERSONAL_SETTING (userid,app_instance_id_key) VALUES('1','"+keyString+"')";
			db.execSQL(sqlPERSONAL_SETTING);
		}
		catch(Exception ex){
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS 'PARTY_DATA'");
		db.execSQL("DROP TABLE IF EXISTS 'LEGISLATOR_TYPE'");
		db.execSQL("DROP TABLE IF EXISTS 'LEGISLATOR_DIST_LIST'");
		db.execSQL("DROP TABLE IF EXISTS 'LEGISLATOR_DATA'");
		db.execSQL("DROP TABLE IF EXISTS 'PERSONAL_SETTING'");
		onCreate(db);		
	}
	
	@Override   
	public void onOpen(SQLiteDatabase db) {     
		super.onOpen(db);       
	           // TODO �C�����\���}�ƾڮw�᭺���Q����     
    } 
	 
	@Override
	public synchronized void close() {
		super.close();
    }
}