import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

class Main {
  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
  }
}


//CREATE TABLE test0 (name VARCHAR(20), td TIMESTAMP);
//INSERT INTO test0 VALUES('SOUMYA','2022-03-11 02:13:04');
//INSERT INTO test0 VALUES('SOUMYA2','2021-04-10 02:16:09');
//SELECT * FROM test0 WHERE DATE(td)='2022-03-11';
//SELECT * FROM test0 WHERE TIME(td)='02:16:09';







