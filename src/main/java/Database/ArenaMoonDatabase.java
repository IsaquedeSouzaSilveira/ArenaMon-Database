package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ArenaMoonDatabase {

	public static void main(String[] args) {

		try (Connection conn = DatabaseConnection.connect();) {
			List<Pokemon> pokemons = DataLoader.loadPokemons(conn);
			List<Ataque> ataques = DataLoader.loadAtaques(conn);
			List<Tipo> tipos = DataLoader.loadTipos(conn);

			// Exemplo: imprimir os Pokémon carregados.
			for (Pokemon p : pokemons) {
				System.out.printf("ID: %d, Nome: %s, Vida: %d, Tipo: %d%n", p.getId(), p.getNome(), p.getVida(),
						p.getTipo());
			}
			for (Ataque at : ataques) {
				System.out.printf("ID: %d, Nome: %s, Dano: %d,Effect: %s, Tipo: %d%n", at.getId(), at.getNome(),
						at.getDano(), at.getEffect(), at.getTipo());
			}
			for (Tipo tipe : tipos) {
				System.out.printf("ID: %d, Nome: %s, ", tipe.getId(), tipe.getTipo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
