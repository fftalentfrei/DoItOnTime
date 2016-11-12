/**
* Prototyp für Anlegen von Objekten in bestimmter Zeit (1 min)
* 
**/
import java.text.SimpleDateFormat
import java.util.Date

object Test {

	def computeTime =(timestamp : Long) => timestamp + 60000;
	def doImport = (counter : Long) => {
		// DEBUG - Last, Produktiv muss dann raus
		Thread.sleep(scala.util.Random.nextInt(10000) + 1000); 
		println("Aufruf für ImportScalaTester(read(xml) -> vapi.createBO())");
		
		//Aktion
        
		counter + 1;		
	}

	def main(args: Array[String]) {
		
		
		var start  = System.currentTimeMillis();
		val now = start;
		val sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
		
		println("Start: " + sdf.format(new Date(start)));
		
		var a = computeTime(start);
		var ctn : Long = 0;
		
	
		while( a > start) {
			ctn = doImport(ctn);
			start = System.currentTimeMillis();
		}
		
		var timeElapsed = System.currentTimeMillis() - now;
		println("Dauer: " + timeElapsed / 1000 + " Sekunden");
		println("angelegte Objekte: " + ctn);
		val ende = java.util.Calendar.getInstance().getTime();
		println("Ende: " + ende)
	}
}
