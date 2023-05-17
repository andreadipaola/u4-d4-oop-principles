package esercizio1;

public class Dipendente {
	Double stipendioBase;
	private String matricola;
	private Double stipendio;
	private Double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;

	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;

		this.stipendioBase = (double) 1000;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = (double) 30;
		this.livello = Livello.OPERAIO;
	}

	public Dipendente(Double stipendioBase, String matricola, Double stipendio, Double importoOrarioStraordinario,
			Livello livello, Dipartimento dipartimento) {
		this.stipendioBase = stipendioBase;
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	public enum Livello {
		OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE
	};

	public enum Dipartimento {
		PRODUZIONE, AMMINITRAZIONE, VENDITE
	};

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public void setImportoOrarioStraordinario(Double importo) {
		this.importoOrarioStraordinario = importo;

	}

	public void stampaDatiDipendente() {
		System.out.printf(
				"Matricola: %s - StipendioBase:  %f - Stipendio: %f - ImportoOrarioStraordinario: %f - Livello: %s - Dipartimento: %s%n",
				matricola, stipendioBase, stipendio, importoOrarioStraordinario, livello, dipartimento);
	}

	public Livello promuovi() {
		switch (livello) {
		case OPERAIO:
			livello = Livello.IMPIEGATO;
			stipendio = stipendioBase * 1.2;
			return livello;

		case IMPIEGATO:
			livello = Livello.QUADRO;
			stipendio = stipendioBase * 1.5;
			return livello;

		case QUADRO:
			livello = Livello.DIRIGENTE;
			stipendio = stipendioBase * 2;
			return livello;

		case DIRIGENTE:
			System.out.println("Non è possibile aumentare oltre il livello");
			return livello;
		default:
			System.out.println("Non è possibile aggiornare il livello");
			return livello;
		}

	}

	static Double calcolaPaga(Dipendente d) {
		return d.stipendio;
	}

	static Double calcolaPaga(Dipendente d, int o) {
		return d.stipendio + o * d.importoOrarioStraordinario;
	}
}
