package esercizio2;

import java.util.stream.DoubleStream;

import esercizio1.Dipendente;
import esercizio1.Dipendente.Dipartimento;
import esercizio1.Dipendente.Livello;

public class GestioneDipendenti {
	public static void main(String[] args) {
		Dipendente dipendenti[] = new Dipendente[4];
		double stipendi[] = new double[4];

		dipendenti[0] = new Dipendente("ABC-123", Dipartimento.PRODUZIONE);
		dipendenti[1] = new Dipendente("ABC-234", Dipartimento.PRODUZIONE);

		dipendenti[2] = new Dipendente((double) 1200, "ABC-345", (double) 1250, (double) 15, Livello.IMPIEGATO,
				Dipartimento.AMMINITRAZIONE);
		dipendenti[3] = new Dipendente((double) 2000, "ABC-456", (double) 2250, (double) 25, Livello.DIRIGENTE,
				Dipartimento.VENDITE);

		dipendenti[1].promuovi();
		dipendenti[2].promuovi();

		for (int i = 0; i < dipendenti.length; i++) {
			dipendenti[i].stampaDatiDipendente();
			stipendi[i] = Dipendente.calcolaPaga(dipendenti[i], 5);

		}
		double sum = DoubleStream.of(stipendi).reduce(0, (a, b) -> a + b);
		System.out.println("Totale stipendi dovuti " + sum);
	}
}
