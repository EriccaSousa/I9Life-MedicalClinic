package i9Life.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date formatData(String data) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAniver;
			dataAniver = df.parse(data);
			return dataAniver;
		} catch (ParseException e) {
			System.out.println("\nErro data.\n");
			e.printStackTrace();
		}

		return null;
	}

	public static Date formatDataHora(String dataHora) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date dateHora = null;
		try {
			dateHora = df.parse(dataHora);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateHora;
	}

}
