package com.cricket.dataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class MainDataBase
{
  private Context context;
  private String createLoginTable = "create table if not exists login(id integer PRIMARY KEY AUTOINCREMENT,clientId text,username text,password text,location text,validity text,auth text)";
  private String createCountTable = "create table if not exists count(id integer PRIMARY KEY AUTOINCREMENT,played text,today text,month text,status text,lastUpdate text)";
  private String createDetailTable = "create table if not exists details(id integer PRIMARY KEY AUTOINCREMENT,clientId text,gameType text,gamePrice text,playerName text,overs text,remBalls text,score text,challScore text,lastUpdate text)";
  private String createPasswordTable = "create table if not exists password(id integer PRIMARY KEY AUTOINCREMENT,pass text)";
  
  private String databaseName = "stanley.db";
  SQLiteDatabase db = null;
  String t="MainDatabase";
  SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm");

  public MainDataBase(Context paramContext)
  {
    this.context = paramContext;
    createDatabase();
    createTable();
  }

  private void createDatabase()
  {
    this.db = this.context.openOrCreateDatabase(this.databaseName, 0, null);
  }

  private void createTable()
  {
    this.db.execSQL(this.createLoginTable);
    this.db.execSQL(this.createCountTable);
    this.db.execSQL(this.createDetailTable);
    this.db.execSQL(this.createPasswordTable);
    Log.i("DB", "Db created");
  }

  public boolean checkForTables()
  {
    Cursor localCursor = this.db.rawQuery("SELECT * FROM login", null);
    if (localCursor.getCount() == 0);
    int i = localCursor.getCount();
    boolean bool = false;
    if (i > 0)
      bool = true;
    localCursor.close();
    return bool;
  }
  
  public boolean checkForCount()
  {
    Cursor localCursor = this.db.rawQuery("SELECT * FROM count", null);
    if (localCursor.getCount() == 0);
    int i = localCursor.getCount();
    boolean bool = false;
    if (i > 0)
      bool = true;
    localCursor.close();
    return bool;
  }

  public void deleteTable()
  {
    this.db.execSQL("delete from login");
    //this.db.close();
  }
  
  public void deleteCount()
  {
    this.db.execSQL("delete from count");
    //this.db.close();
  }

  public void deleteDetail()
  {
    this.db.execSQL("delete from details");
    //this.db.close();
  }

  public void deletePass()
  {
	  try{
    this.db.execSQL("delete from password");
	  }
	  catch(Exception e){
		  ;
	  }
    //this.db.close();
  }
  
  
  public List<Login> extractValue()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = this.db.rawQuery("select * from login", null);
      localCursor.moveToFirst();
      while (true)
      {
        if (localCursor.isAfterLast())
          return localArrayList;
        Login localLogin = new Login();
        localLogin.setUsername(localCursor.getString(1));
        localLogin.setPassword(localCursor.getString(2));
        localArrayList.add(localLogin);
        localCursor.moveToNext();
      }
    }
    catch (Exception localException)
    {
      Toast.makeText(this.context, "Not extracted " + localException.toString(), 1).show();
    }
    return localArrayList;
  }

  public boolean insertValue(String paramString0,String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = "insert into login(clientId,username,password,location,validity,auth) values('"+paramString0+"','" + paramString1 + "'" + "," + "'" + paramString2 + "'" + "," + "'" + paramString3 + "'" + "," + "'" + paramString4 + "','" +paramString5+ "')";
    Log.i(t,"Query "+str);
    try
    {
    	if(checkForTables())
    		deleteTable();
      this.db.execSQL(str);
      return true;
    }
    catch (Exception localException)
    {
      Toast.makeText(this.context, "Not inserted " + localException.toString(), 1).show();
      return false;
    }
   
  }
  
  public boolean insertCounts(String status){
	  int i=0;
	  
	  String today = "1";
		 String played = "1";
		 String month = "1";
		 Log.d(t,"Net "+checkForCount()+status+" "+getDate().substring(0, 2));
		 String date = this.df.format(Calendar.getInstance().getTime()); 
		 	if(checkForCount()){
		 		if(Integer.parseInt(getDate().substring(0, 2)) < Integer.parseInt(date.substring(0, 2)))
	    			   updateToday();
	    		   if(Integer.parseInt(getDate().substring(3,5)) < Integer.parseInt(date.substring(3,5))){
	    			   updateToday();
	    			   updateMonth();
	    		   }
		 		if(status=="0"){
				  i = Integer.parseInt(getToday())+1;
				   today = ""+i;
				  i = Integer.parseInt(getPlayed())+1;
				   played = ""+i;
				  i=Integer.parseInt(getMonth())+1;
				   month = ""+i;
		 		}
		 		else{
		 			today = ""+Integer.parseInt(getToday());
		 			played = ""+Integer.parseInt(getPlayed());
		 			month = ""+Integer.parseInt(getMonth());
		 		}
		 	}
	 
	  Log.i(t,"date "+date);
	  String str = "insert into count(today,played,month,status,lastUpdate) values('" + today + "','" + played + "'" + "," + "'" + month + "'," + "'" + status +"'," + "'" + date +"')";
	  Log.i(t,"Query "+str);  
	  try
	    {
	    	if(checkForCount()){
	    		
	    		deleteCount();
	    	}
	    	this.db.execSQL(str);
	    	return true;
	    }
	    catch(Exception e){
	    	Toast.makeText(this.context, "Not inserted " + e.toString(), Toast.LENGTH_SHORT).show();
	    	 return false;
	    }
	 
  }
  
  public String getclientId(){
	  String str = "select clientId from login";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "login";
	  }
  }
  
  public String getAuth(){
	  String str = "select auth from login";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "login";
	  }
  }
  
  public String getValidity(){
	  String str = "select validity from login";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "1";
	  }
  }
  
  public String getToday(){
	  String str = "select today from count";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "0";
	  }
  }
  
  public String getMonth(){

	  String str = "select month from count";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "0";
	  }
  }
  
  public String getPlayed(){
	  String str = "select played from count";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "0";
	  }
  
  }
  
  public Integer getStatus(){
	  String str = "select status from count";
	  try{
		  Cursor cursor = db.rawQuery(str, null);
		  cursor.moveToFirst();
		  return cursor.getInt(0);
	  }
	  catch(Exception e){
		  return 0;
	  }
	  
  }
  
  public String getDate(){
	  String str = "select lastUpdate from count";
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return df.format(Calendar.getInstance().getTime());
	  }
  
  }
  
  public void updateLogin(String auth,String validity,String user,String pass){
	  String str = "UPDATE login SET username='"+user+"', password='"+pass+"', auth='"+auth+"', validity='"+validity+"'";
	  try{
		  db.execSQL(str);
	  }
	  catch(Exception e){
		  Log.e(t,"Error "+e);
	  }
  }
  
  public void updateCounts(String played){
	 String date =  this.df.format(Calendar.getInstance().getTime()); 
	  String str = "insert into count(today,played,month,status,lastUpdate) values('0','" + played + "'" + "," + "'0'," + "'0'," + "'" + date +"')";
		   try{
		  db.execSQL(str);
	  }
	  catch(Exception e){
		  Log.e(t,"Error "+e);
	  }
  }
  
  public void updateToday(){
	  String str = "UPDATE count SET today='0'";
	  try{
		  db.execSQL(str);
	  }
	  catch(Exception e){
		  Log.e(t,"Error "+e);
	  }
  }
  public void updateMonth(){
	  String str = "UPDATE count SET month='0'";
	  try{
		  db.execSQL(str);
	  }
	  catch(Exception e){
		  Log.e(t,"Error "+e);
	  }
  }
  
  public void insertDetails(String clientId,String gamePrice,String gameType,String playerName ,String overs ,String remBalls,String score ,String challScore ,String lastUpdate ){
		 String date =  this.df.format(Calendar.getInstance().getTime()); 
		  String str = "insert into details(clientId,gamePrice,gameType,playerName,overs,remBalls,score,challScore,lastUpdate) values('"+clientId+"','" + gamePrice + "','"+gameType+"','"+playerName+"','"+overs+"','"+remBalls+"','"+score+"','"+challScore+"','" + date +"')";
			   try{
			  db.execSQL(str);
		  }
		  catch(Exception e){
			  Log.e(t,"Error "+e);
		  }
	  }
  public JSONArray getDetails(){
	  String str = "select clientId,gameType,gamePrice,playerName,overs,remBalls,score,challScore,lastUpdate from details";//order by id desc LIMIT 0,1";
	  
	  JSONArray jArray = new JSONArray();
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  int j=0;
		  while(!localcursor.isAfterLast()){
			  JSONObject jObject = new JSONObject();
			  for(int i=0;i<localcursor.getColumnCount();i++){
				  Log.i(t,"Cols "+localcursor.getString(i));
				  jObject.put(localcursor.getColumnName(i),localcursor.getString(i));
			  }
			  localcursor.moveToNext();
			  jArray.put(j,jObject);
			  j++;
		  }
		  return jArray;
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return jArray;
	  }
  
  }
  
  public String getPrice(){
	  String str = "select gamePrice from details";
	  int pricing=0;
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  while(!localcursor.isAfterLast()){
			  pricing = pricing+localcursor.getInt(0);
			  localcursor.moveToNext();
		  }
		  return pricing+"";
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "0";
	  }
  
  }
  
  public void insertPass(String pass ){
		  String str = "insert into password(pass) values('"+pass+"')";
			   try{
			  db.execSQL(str);
		  }
		  catch(Exception e){
			  Log.e(t,"Error "+e);
		  }
	  }
  
  public String getPass(){
	  String str = "select pass from password";
	 
	  try{
		  Cursor localcursor = db.rawQuery(str,null);
		  localcursor.moveToFirst();
		  return localcursor.getString(0);
	  }
	  catch(Exception e){
		  Log.d(t,"Error "+e);
		  return "1324";
	  }
  
  }
  
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.dataBase.MainDataBase
 * JD-Core Version:    0.6.2
 */